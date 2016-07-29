/*
 * Copyright (c) 2016, MigDB(http://www.migdb.org) All Rights Reserved.
 *
 * MigDB. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.migdb.migdbserver.main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.migdb.migdbserver.main.config.AuthenticationParameters;
import org.migdb.migdbserver.main.resources.MappingRequestMessage;
import org.migdb.migdbserver.main.resources.MappingResponse;
import org.migdb.migdbserver.main.services.AuthorizationFilter;
import org.migdb.migdbserver.main.services.BuildResponse;
import org.migdb.migdbserver.main.services.MappingRequestValidator;
import org.migdb.migdbserver.main.services.NeuralNetworkAccess;


@Path("/mappingrequest")
public class MappingRequest {

	/**
	 * @return server status;
	 */

	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response serverStatus(@Context UriInfo uriinfo) {
		String serverStatus = "ONLINE";
		MappingResponse mappingresponse = new MappingResponse(serverStatus);

		return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath())
				.header("Base-URI", uriinfo.getBaseUri())
				.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
						AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
				.entity(mappingresponse).build();

	}

	/**
	 * @return response message with mapping model
	 * @return error message with error code accept both application/json and
	 *         application/xml
	 */
	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response retrunMappingResponse(MappingRequestMessage mappingrequest, @Context UriInfo uriinfo) {
		// validate client request for mapping model
		MappingRequestValidator mappingRequestValidator = new MappingRequestValidator(mappingrequest);
		mappingRequestValidator.validateMappingRequest();

		// access neural network and process parameters
		NeuralNetworkAccess neuralnetworkaccess = new NeuralNetworkAccess();

		// build response from the response returning from neural network
		BuildResponse buildresponse = new BuildResponse(neuralnetworkaccess.getNeuralResponse(mappingrequest));
		MappingResponse mappingresponse = buildresponse.getMappingResponse();

		// build final response message format and include extra data of status
		return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath())
				.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
						AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
				.entity(mappingresponse).build();

	}

}

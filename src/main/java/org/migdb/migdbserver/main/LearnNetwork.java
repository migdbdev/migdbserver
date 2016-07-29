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
import org.migdb.migdbserver.main.neuralnetwork.NetworkConfiguration;
import org.migdb.migdbserver.main.neuralnetwork.NeuralNetworkCore;
import org.migdb.migdbserver.main.neuralnetwork.UpdateNetwork;
import org.migdb.migdbserver.main.resources.DataSetUpdateRequestMessage;
import org.migdb.migdbserver.main.resources.NetworkResponse;
import org.migdb.migdbserver.main.services.AuthorizationFilter;

@Path("/learnnetwork")
public class LearnNetwork {

	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response restartNetwork(@Context UriInfo uriinfo) {
		UpdateNetwork update = new UpdateNetwork();
		NeuralNetworkCore core = new NeuralNetworkCore();
		NetworkConfiguration config = new NetworkConfiguration();
		NetworkResponse response = new NetworkResponse();
		if (update.updateNetworkStatus(core, config)) {
			String message = "Neural Network Successfully updated!";
			response.setResponseParameters(message, true, false, 0);

		}

		else {
			String message = "Error occured while updating server.see console";
			response.setResponseParameters(message, false, false, 0);

		}
		return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath())
				.header("Base-URI", uriinfo.getBaseUri())
				.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
						AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
				.entity(response).build();

	}

	/**
	 * @return response message with mapping model
	 * @return error message with error code accept both application/json and
	 *         application/xml
	 */
	@POST()
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateLearningDataSet(DataSetUpdateRequestMessage updatemessage, @Context UriInfo uriinfo) {
		NetworkResponse response = new NetworkResponse();
		NetworkConfiguration config = new NetworkConfiguration();
		if (updatemessage.validateDataSetUpdateRequestMessage()) {
			updatemessage.setModelValueToParameter(config);
			UpdateNetwork update = new UpdateNetwork();

			update.appendLineToDataSet(config.getTableInfoFilePath(), updatemessage.createRowValueText());
			update.readAndPrintDataSet(config.getTableInfoFilePath());
			System.out.println("Dataset Updated Successfully....");

			String message = "Data Row inserted succesfully!";
			response.setResponseParameters(message, false, true, 1);

		} else {
			String message = "Data Row contains errors";
			response.setResponseParameters(message, false, false, 0);

		}

		// build final response message format and include extra data of status
		return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath())
				.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
						AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
				.entity(response).build();

	}

}
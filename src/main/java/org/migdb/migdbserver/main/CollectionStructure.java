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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;
import org.migdb.migdbserver.main.config.AuthenticationParameters;
import org.migdb.migdbserver.main.config.ErrorCodes;
import org.migdb.migdbserver.main.neuralnetwork.FilePath;
import org.migdb.migdbserver.main.resources.CollectionStructureJSON;
import org.migdb.migdbserver.main.resources.ErrorMessage;
import org.migdb.migdbserver.main.resources.MappingResponse;
import org.migdb.migdbserver.main.services.AuthorizationFilter;

@Path("/collectionstructure")
public class CollectionStructure {

	@POST()
	@Path("/save")
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response saveCollectionStructure(CollectionStructureJSON structure ,  @Context UriInfo uriinfo) {
		System.out.println("service triggered");

		if(structure.getJsonContent().length() > 0 && structure.getJsonContent()!= null){

		String collectionStructure = structure.getJsonContent();
		org.json.JSONObject jsonObject = new JSONObject(collectionStructure);
		String nameIdentifier = getNextUUID();
		String storePath = FilePath.COLLECTIONSTORE.getPath();
		String dynamicFilename = storePath + nameIdentifier + ".json";
		File jsonFile = new File(dynamicFilename);
		jsonFile.getParentFile().mkdirs();
		try {
			boolean filecreated = jsonFile.createNewFile();
			if(filecreated){
				try(FileWriter filewriter = new FileWriter(dynamicFilename);){
					filewriter.write(jsonObject.toString());
					MappingResponse response = new MappingResponse("Json file successfully created",nameIdentifier);
					System.out.println("JSon File Created: "+dynamicFilename);
					return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath())
							.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
									AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
							.header("structureConsumerURI",uriinfo.getBaseUri()+"collectionstructure/get/"+nameIdentifier)
							.entity(response).build();



				} catch (IOException e) {
					ErrorMessage errormessage = new ErrorMessage(ErrorCodes.UNABLE_WRITE_JSON_FILE, e.getMessage(),
							"path to documentation");
					return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errormessage)
							.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
									AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
							.build();
				}
			}
			else{
				ErrorMessage errormessage = new ErrorMessage(ErrorCodes.UNABLE_WRITE_JSON_FILE,"Josn file not created",
						"path to documentation");
				return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errormessage)
						.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
								AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
						.build();
			}
		} catch (IOException e1) {
			ErrorMessage errormessage = new ErrorMessage(ErrorCodes.UNABLE_CREATE_JSON_FILE, e1.getMessage(),
					"path to documentation");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errormessage)
					.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
							AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
					.build();
		}
		}
		else{
			ErrorMessage errormessage = new ErrorMessage(ErrorCodes.INVALID_PARAMETRS, "Empty Json File",
					"path to documentation");
			return Response.status(Status.BAD_REQUEST).entity(errormessage)
					.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
							AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
					.build();

		}

	}

	@GET()
	@Path("/get/{jsonfile}")
	public Response getJSONFile(@PathParam("jsonfile") String jsonfile,  @Context UriInfo uriinfo) {
		if(jsonfile.length() > 0){
		try {
			String storePath = FilePath.COLLECTIONSTORE.getPath();
			String jsonURI = storePath + jsonfile + ".json";
			String content = readFile(jsonURI, Charset.defaultCharset());
			if(content.length() > 0){
			System.out.println("JSON file returned ("+jsonfile+".json)");
			return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath())
					.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
							AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
					.entity(content).build();
			}
			else{
				ErrorMessage errormessage = new ErrorMessage(ErrorCodes.GENERIC_ERROR,"Server JSON file empty",
						"path to documentation");
				return Response.status(Status.NO_CONTENT).entity(errormessage)
						.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
								AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
						.build();
			}

		} catch (IOException e) {
			ErrorMessage errormessage = new ErrorMessage(ErrorCodes.GENERIC_ERROR,e.getMessage(),
					"path to documentation");
			return Response.status(Status.NO_CONTENT).entity(errormessage)
					.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
							AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
					.build();
		}
		}
		else{
			ErrorMessage errormessage = new ErrorMessage(ErrorCodes.GENERIC_ERROR,"Request is empty",
					"path to documentation");
			return Response.status(Status.BAD_REQUEST).entity(errormessage)
					.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
							AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
					.build();
		}

	}

	public static String getNextUUID() {
        return UUID.randomUUID().toString();
    }

	public static String readFile(String path, Charset encoding)
			  throws IOException
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}

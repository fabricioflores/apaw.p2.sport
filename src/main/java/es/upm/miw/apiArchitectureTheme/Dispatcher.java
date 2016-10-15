package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.api.UserResource;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidRequestException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	// private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/users
		if ("users".equals(request.getPath())) {
			response.setBody(userResource.usersList().toString());
			// **/users/search
		} else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])
				&& (request.getParams().size() == 1 && request.getParams().containsKey("sport"))) {
			try {
				response.setBody(userResource.searchBySport(request.getParams().get("sport")).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		// switch (request.getPath()) {
		// // POST **/themes body="themeName"
		// case "themes":
		// // Injectar parámetros...
		// try {
		// themeResource.createTheme(request.getBody());
		// response.setStatus(HttpStatus.CREATED);
		// } catch (InvalidThemeFieldException e) {
		// this.responseError(response, e);
		// }
		// break;
		// // POST votes body="themeId:vote"
		// case "votes":
		// String themeId = request.getBody().split(":")[0];
		// String vote = request.getBody().split(":")[1];
		// try {
		// voteResource.createVote(Integer.valueOf(themeId),
		// Integer.valueOf(vote));
		// response.setStatus(HttpStatus.CREATED);
		// } catch (Exception e) {
		// responseError(response, e);
		// }
		// break;
		// default:
		// responseError(response, new
		// InvalidRequestException(request.getPath()));
		// break;
		// }
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		// switch (request.getPath()) {
		// default:
		// responseError(response, new
		// InvalidRequestException(request.getPath()));
		// break;
		// }
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		// switch (request.getPath()) {
		// default:
		// responseError(response, new
		// InvalidRequestException(request.getPath()));
		// break;
		// }
	}

}
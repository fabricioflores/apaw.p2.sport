package sport.main;

import sport.api.SportResource;
import sport.api.UserResource;
import sport.exceptions.InvalidRequestException;
import sport.http.HttpRequest;
import sport.http.HttpResponse;
import sport.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

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
		switch (request.getPath()) {
		// POST **/users body="nick:email"
		case "users":
			try {
				userResource.createUser(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				this.responseError(response, e);
			}
			break;
		// POST sports body="sportName"
		case "sports":
			String sportName = request.getBody();
			try {
				sportResource.createSport(sportName);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			try {
				String sportName = request.getBody();
				userResource.addSport(request.paths()[1], sportName);
				response.setStatus(HttpStatus.OK);
			} catch (Exception e) {
				this.responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		responseError(response, new InvalidRequestException(request.getPath()));
	}

}

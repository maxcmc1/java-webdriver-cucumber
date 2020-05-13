package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static support.TestContext.getTestDataMap;
import static support.TestContext.setTestData;

public class RestWrapper implements Loggable {

//    public Logger getLogger(){
//        return LogManager.getLogger(RestWrapper.class);
//    }

    private String baseUrl = "https://skryabin.com/recruit/api/v1/"; // this url also called endpoint
    private static String loginToken;

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "Authorization";

    public RestWrapper login(Map<String, String> user) {

        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl) // end point (end point consists of base URI and path (login))
                .basePath("login") // end point (end point consists of base URI and path (login))
                .header(CONTENT_TYPE, JSON)
                .body(user);

        // execute
        Response response = request
                .when()
                .post();

        // verify and extract
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");   // if it's empty - it means everything

        loginToken = "Bearer " + result.get("token");
        System.out.println(loginToken);

        return new RestWrapper();

    }


    public Map<String, Object> createPosition(Map<String, String> position) {
        getLogger().info("Creating Position " + position.get("title"));

        String dateOpen = position.get("dateOpen");
        String isoDateOpen = new SimpleDateFormat("yyyy-MM-dd").format(new Date(dateOpen));
        position.put("dateOpen", isoDateOpen);

        //prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions")
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(position);

        //execute
        Response response = request
                .when()
                .post();

        // verify and extract
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap(""); // if it's empty - it means everything

        setTestData("newPosition", result);

        return result;

    }

    public List<Map<String, Object>> getPositions() {
        getLogger().info("Reading list of positions");
        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions");

        // execute
        Response response = request
                .when()
                .get();


        //verify and extract
        List<Map<String, Object>> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        return result;

    }

    public Map<String, Object> updatePosition(Map<String, String> fields, Object id) {
        getLogger().info("Updating position with id: " + id);
        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(fields);

        // execute
        Response response = request
                .when()
                .patch();

        // verify and extract
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");


        Map<String, Object> newPosition = getTestDataMap("newPosition");
        for (String key : result.keySet()) {
            newPosition.put(key, result.get(key));
        }
        setTestData("newPosition", newPosition);

        return result;

    }

    public Map<String, Object> getPositionById(Object id) {
        Map<String, Object> result = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public void deletePositionById(Object id) {
        RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("positions/" + id)
                .header(AUTH, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);
    }

    public Map<String, Object> createCandidate(Map<String, String> candidate) {
        //prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates")
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(candidate);

        //execute
        Response response = request
                .when()
                .post();

        // verify and extract
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap(""); // if it's empty - it means everything

        setTestData("newCandidate", result);

        return result;
    }

    public List<Map<String, Object>> getCandidates() {
        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates");

        // execute
        Response response = request
                .when()
                .get();


        //verify and extract
        List<Map<String, Object>> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        return result;

    }

    public Map<String, Object> updateCandidate(Map<String, String> fields, Object id) {
        // prepare
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates/" + id)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(fields);

        // execute
        Response response = request
                .when()
                .patch();

        // verify and extract
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        Map<String, Object> newCandidate = getTestDataMap("newCandidate");
        for (String key : result.keySet()) {
            newCandidate.put(key, result.get(key));
        }
        setTestData("newCandidate", newCandidate);

        return result;
    }

    public Map<String, Object> getCandidateById(Object id) {
        Map<String, Object> result = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates/" + id)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public void deleteCandidateById(Object id) {
        RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("candidates/" + id)
                .header(AUTH, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(204);
    }

}

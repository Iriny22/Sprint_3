import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName; // импорт DisplayName
import io.qameta.allure.Description; // импорт Description

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class CourierPositiveTest {

    private CourierClient courierClient;
    private Courier courier;
    private int id;

    @Before
    public void setUp() {

        courierClient = new CourierClient();
        courier = CourierGenerator.getDefault();

    }

    @After
    public void cleanUp() {
        courierClient.delete(id);
    }

    @Test
    @DisplayName("Create curier") // имя теста
    @Description("Basic test for post request to /api/v1/courier") // описание теста
    public void courierCreatedPositive() {

        ValidatableResponse responseCreate = courierClient.create(courier);

        ValidatableResponse  responseLogin = courierClient.login(Credential.from(courier));

        System.out.println("Ответ при создании курьера "+ responseCreate.extract());
        System.out.println("Ответ при создании курьера "+ responseLogin.extract());
        int statusCode = responseCreate.extract().statusCode();
        System.out.println("statusCode "+ statusCode);
        System.out.println("statusCode login "+ responseLogin.extract().statusCode());

        id = responseLogin.extract().path("id");
        System.out.println("id "+ responseCreate);

        boolean isCourierCreated = responseCreate.extract().path("ok");

        assertEquals(201,statusCode);

    }
}


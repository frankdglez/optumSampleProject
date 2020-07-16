package com.optum.optumsample.controller;

import com.optum.optumsample.exception.CustomException;
import com.optum.optumsample.model.User;
import com.optum.optumsample.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsersController.class)
class UsersControllerTest {
    private List<User> users = new ArrayList<>();
    //http client
    @Autowired
    private MockMvc mvc;

    //Generate mock userService it does not affect the DB
    @MockBean
    private UserService userService;

    @BeforeEach()
    public void setUp() {
        users.add(new User() {{
            setUser_id(1L);
            setFirstName("DummyName");
            setMiddleInitial("D");
            setLastName("DummyLastName");
            setCity("DummyCity");
            setState("DummyMN");
            setZipCode("MN9999");
            setPhoneNumber("9876543215");
        }});
        users.add(new User() {{
            setUser_id(2L);
            setFirstName("DummySecond");
            setMiddleInitial("S");
            setLastName("DummyLastSecond");
            setCity("DummyCitySecond");
            setState("DummyMN");
            setZipCode("MN9999888");
            setPhoneNumber("9876543215");
        }});
    }

    @Test
    void retrieveAllUsers() throws Exception {
        given(userService.getAllUsers()).willReturn(users);
        mvc.perform(get("/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is(users.get(0).getFirstName())));
    }

    @Test
    void failOnZeroUsers() throws Exception {
        users.clear();
        given(userService.getAllUsers()).willThrow(new CustomException(CustomException.NOT_EXISTING_RESOURCE, HttpStatus.NOT_FOUND));//.willReturn(users);
        mvc.perform(get("/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(CustomException.NOT_EXISTING_RESOURCE));
    }

    @Test
    void retrieveAnExistingUser() throws Exception {
        given(userService.getById(anyLong())).willReturn(users.get(1));
        mvc.perform(get("/user/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void failOnRetrieveAnNotExistingUser() throws Exception {
        given(userService.getById(anyLong())).willThrow(new CustomException(CustomException.NOT_EXISTING_RESOURCE, HttpStatus.NOT_FOUND));
        mvc.perform(get("/user/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(CustomException.NOT_EXISTING_RESOURCE));
    }

    @Test
    void createANewUser() throws Exception {
        given(userService.saveUser(anyObject())).willReturn(users.get(0));
        mvc.perform(post("/save")
                .content("{\n" +
                        "    \"firstName\" : \"Francisco\",\n" +
                        "    \"middleInitial\": \"D\",\n" +
                        "    \"lastName\": \"Gonzalez\",\n" +
                        "    \"city\":\"Minneapolis\",\n" +
                        "    \"state\" : \"MN\",\n" +
                        "    \"zipCode\": \"55414\",\n" +
                        "    \"phoneNumber\" : \"915-702-7878\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void failOnCreateWhenUserNAmeOrLastNameNotExisting() throws Exception {
        given(userService.saveUser(anyObject())).willThrow(new CustomException(CustomException.NOT_EXISTING_RESOURCE, HttpStatus.NOT_FOUND));
        mvc.perform(post("/save")
                .content("{\n" +
                        "    \"middleInitial\": \"D\",\n" +
                        "    \"city\":\"Minneapolis\",\n" +
                        "    \"state\" : \"MN\",\n" +
                        "    \"zipCode\": \"55414\",\n" +
                        "    \"phoneNumber\" : \"915-702-7878\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}

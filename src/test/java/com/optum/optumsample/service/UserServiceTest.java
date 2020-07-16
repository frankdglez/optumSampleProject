package com.optum.optumsample.service;

import com.optum.optumsample.exception.CustomException;
import com.optum.optumsample.model.User;
import com.optum.optumsample.persistence.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {
    private final User user = new User();
    private final IUserRepository iUserRepositoryMock = mock(IUserRepository.class);
    private final UserService userService = new UserService(iUserRepositoryMock);

    @BeforeEach()
    public void setUp() {
        user.setUser_id(1L);
        //user.setFirstName("DummyName");
        user.setMiddleInitial("D");
        //user.setLastName("DummyLastName");
        user.setCity("DummyCity");
        user.setState("DummyMN");
        user.setZipCode("MN9999");
        user.setPhoneNumber("9876543215");
    }

    @Test()
    void shouldFailFirstNameOrLastNameNullOnSaveUser() {
        when(iUserRepositoryMock.save(user)).thenReturn(user);
        CustomException exception = assertThrows(CustomException.class, () -> userService.saveUser(user), "Fail");
        assertTrue(exception.getMessage().contains(CustomException.NOT_EXISTING_RESOURCES));
    }

    @Test
    void shouldFailOnEmptyDataBaseOnGetAllUsers() {
        when(iUserRepositoryMock.count()).thenReturn(0L);
        CustomException exception = assertThrows(CustomException.class, userService::getAllUsers, "Fail");
        assertTrue(exception.getMessage().contains(CustomException.NOT_EXISTING_RESOURCE));
    }

    @Test
    void shouldTrowAnExceptionIfThereIsNoResultOnGetById() {
        when(iUserRepositoryMock.findById(anyLong())).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class, () -> userService.getById(1L), "Fail");
        assertTrue(exception.getMessage().contains(CustomException.NOT_EXISTING_RESOURCE));
    }
}

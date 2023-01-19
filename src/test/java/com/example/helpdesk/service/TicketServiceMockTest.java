package com.example.helpdesk.service;

import com.example.helpdesk.storage.StaffStorage;
import com.example.helpdesk.storage.TicketStorage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TicketServiceMockTest {

    @Mock
    private StaffStorage staffStorage;
    @Mock
    private TicketStorage ticketStorage;

    @InjectMocks
    private TicketService service;

}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnotherServiceTest {
    @InjectMocks
    private AnotherService service;

    @Mock
    private SomeService someService;

    @Test
    public void testThrowsOnNonCalculateParameter() {
        final var exception = assertThrows(DomainException.class, () -> service.bar(false));
        assertEquals("Unexpected stuff happened", exception.getMessage());
    }

    @Test
    public void testSomeServiceResultUsed() {
        when(someService.foo()).thenReturn(42);
        final var result = assertDoesNotThrow(() -> service.bar(true));
        assertEquals("Some service returned 42", result);
    }
}

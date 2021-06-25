import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.InjectMocks
import org.mockito.Mock
import org.junit.jupiter.api.Test
import kotlin.Throws
import org.mockito.Mockito

@ExtendWith(MockitoExtension::class)
class AnotherServiceTest {
    @InjectMocks
    private lateinit var service: AnotherService

    @Mock
    private lateinit var someService: SomeService
    @Test
    fun testThrowsOnNonCalculateParameter() {
        val exception = Assertions.assertThrows(DomainException::class.java) { service!!.bar(false) }
        Assertions.assertEquals("Unexpected stuff happened", exception.message)
    }

    @Test
    @Throws(DomainException::class)
    fun testSomeServiceResultUsed() {
        Mockito.`when`(someService!!.foo()).thenReturn(42)
        val result = service!!.bar(true)
        Assertions.assertEquals("Some service returned 42", result)
    }
}
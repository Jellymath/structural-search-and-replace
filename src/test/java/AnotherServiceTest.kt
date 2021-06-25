import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.InjectMocks
import org.mockito.Mock
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
class AnotherServiceTest {
    @InjectMocks
    private lateinit var service: AnotherService

    @Mock
    private lateinit var someService: SomeService

    @Test
    fun testThrowsOnNonCalculateParameter() {
        val exception = assertFailsWith<DomainException> { service.bar(false) }
        assertEquals("Unexpected stuff happened", exception.message)
    }

    @Test
    fun testSomeServiceResultUsed() {
        whenever(someService.foo()) doReturn 42
        val result = service.bar(true)
        assertEquals("Some service returned 42", result)
    }
}
public class AnotherService {
    private final SomeService someService;

    public AnotherService(final SomeService someService) {
        this.someService = someService;
    }

    public String bar(final boolean calculate) throws DomainException {
        if (!calculate) {
            throw new DomainException("Unexpected stuff happened");
        }
        return "Some service returned " + someService.foo();
    }
}

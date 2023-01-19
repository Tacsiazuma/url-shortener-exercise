package app.tier.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomIdGeneratorTest {

    private final RandomIdGenerator underTest = new RandomIdGenerator();
    @Test
    public void itShouldReturnBase58Chars() {
        // GIVEN
        String base58Expectations = "[123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz]+";
        // WHEN
        String actual = underTest.getBase58(10);
        // THEN
        assertTrue(actual.matches(base58Expectations));
    }

    @Test
    public void itShouldRespectGivenLength() {
        // GIVEN
        String base58Expectations = ".{10}";
        // WHEN
        String actual = underTest.getBase58(10);
        // THEN
        assertTrue(actual.matches(base58Expectations));
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class L0459_RepeatedSubstringPatternTest {
    
    L0459_RepeatedSubstringPattern solution = new L0459_RepeatedSubstringPattern();
    
    @Test
    void repeatedSubstringPattern() {
        // 测试用例 1
        assertTrue(solution.repeatedSubstringPattern("abab"));
        
        // 测试用例 2
        assertFalse(solution.repeatedSubstringPattern("aba"));
        
        // 测试用例 3
        assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"));
        
        // 额外测试用例
        assertTrue(solution.repeatedSubstringPattern("aa"));
        assertFalse(solution.repeatedSubstringPattern("a"));
        assertTrue(solution.repeatedSubstringPattern("abaababaab"));
    }
} 
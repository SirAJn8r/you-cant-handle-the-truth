import org.junit.Test;

import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {
        PrintStream output = new PrintStream(System.out);

        String[] inputs =
        {
            "son we live in a world that has walls and those walls have to be guarded by men with guns whos gonna do it you you lieutenant weinberg i have a greater responsibility than you can possibly fathom you weep for santiago and you curse the marines you have that luxury you have the luxury of not knowing what i know that santiagos death while tragic probably saved lives and my existence while grotesque and incomprehensible to you saves lives you dont want the truth because deep down in places you dont talk about at parties you want me on that wall you need me on that wall we use words like honor code loyalty we use these words as the backbone of a life spent defending something you use them as a punchline i have neither the time nor the inclination to explain myself to a man who rises and sleeps under the blanket of the very freedom that i provide and then questions the manner in which i provide it i would rather you just said thank you and went on your way otherwise i suggest you pick up a weapon and stand a post either way i dont give a damn what you think you are entitled to",
            "the the THE The thE tHE Capitalisation Tests",
            "this is to test the ordering of the words that this test outputs", //the answer is weirdly ordered because hashmaps.
            "Ho`w mess^ed %up c$#2n I m(){}ake th;'s senten<>ce.?!",
            "What happens with a \n breakline"
        };
        String[] expected =
        {
            "{18=[you], 9=[the], 8=[a, and, i], 6=[that], 5=[have, to], 3=[in, use, of, dont, we, on], 2=[lives, want, words, it, while, way, as, walls, what, provide, me, luxury, wall], 1=[explain, very, guns, saved, lieutenant, about, your, these, saves, would, pick, fathom, grotesque, incomprehensible, because, greater, give, sleeps, went, loyalty, myself, them, then, something, at, knowing, santiago, curse, weinberg, entitled, whos, be, probably, world, freedom, responsibility, are, by, tragic, backbone, man, stand, inclination, think, gonna, suggest, places, thank, under, punchline, honor, existence, defending, questions, do, manner, down, either, son, post, than, talk, has, up, those, possibly, which, otherwise, need, like, my, parties, know, santiagos, rises, who, deep, code, death, rather, for, weep, life, nor, guarded, can, weapon, not, men, said, just, live, spent, damn, with, truth, marines, neither, time, blanket]}",
            "{2=[the], 1=[THE, The, thE, tHE, Capitalisation, Tests]}",
            "{2=[the, test, this], 1=[outputs, that, ordering, of, words, is, to]}",
            "{1=[%up, th;'s, m(){}ake, senten<>ce.?!, I, Ho`w, c$#2n, mess^ed]}",
            "{1=[with, a, breakline, \n, What, happens]}"
        };

        for(int i = 0; i < inputs.length; i++)
        {
            String result = HandleTruth.wordCount(inputs[i], output);
            assertEquals("Test " + i + " has failed. Result = " + result, expected[i], result);
        }
    }
}
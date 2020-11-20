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
            "this is to test the ordering of the words that this test outputs",
            "Ho`w mess^ed %up c$#2n I m(){}ake th;'s senten<>ce.?!",
            "What happens with a \n breakline",
            "",
            "What happens with a  doublespace"
        };
        String[] expected =
        {
            "{18=[you], 9=[the], 8=[a, and, i], 6=[that], 5=[have, to], 3=[in, use, of, dont, we, on], 2=[lives, want, words, it, while, way, as, walls, what, provide, me, luxury, wall], 1=[explain, very, guns, saved, lieutenant, about, your, these, saves, would, pick, fathom, grotesque, incomprehensible, because, greater, give, sleeps, went, loyalty, myself, them, then, something, at, knowing, santiago, curse, weinberg, entitled, whos, be, probably, world, freedom, responsibility, are, by, tragic, backbone, man, stand, inclination, think, gonna, suggest, places, thank, under, punchline, honor, existence, defending, questions, do, manner, down, either, son, post, than, talk, has, up, those, possibly, which, otherwise, need, like, my, parties, know, santiagos, rises, who, deep, code, death, rather, for, weep, life, nor, guarded, can, weapon, not, men, said, just, live, spent, damn, with, truth, marines, neither, time, blanket]}",
            "{6=[the], 1=[tests, capitalisation]}", //before Capitalisation bugfix, each capitalisation of 'the' was a different word
            "{2=[the, test, this], 1=[outputs, that, ordering, of, words, is, to]}", //the answer is weirdly ordered because hashmaps, not a bug
            "{1=[%up, th;'s, m(){}ake, senten<>ce.?!, i, c$#2n, ho`w, mess^ed]}",
            "{1=[with, a, what, breakline, \n, happens]}", //\n is a word in this case, interesting. I don't think this is explicitly a bug though.
            "{}", //before empty-word bugfix, the output would have been "{1=[]}" because it considered "" to be a word.
            "{1=[with, a, what, happens, doublespace]}" //before empty-word bugfix output would be "{1=[, with, a, what, happens, doublespace]}"
        };

        for(int i = 0; i < inputs.length; i++)
        {
            String result = HandleTruth.wordCount(inputs[i], output);
            assertEquals("Test " + i + " has failed. Result = " + result, expected[i], result);
        }
    }
}
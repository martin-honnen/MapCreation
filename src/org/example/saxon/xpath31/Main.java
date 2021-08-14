package org.example.saxon.xpath31;

import net.sf.saxon.s9api.*;

import java.io.File;

public class Main {

    public static void main(String[] args) throws SaxonApiException {
        Processor processor = new Processor(false);

        DocumentBuilder docBuilder = processor.newDocumentBuilder();

        XdmNode inputDoc = docBuilder.build(new File("sample1.xml"));

        XdmMap result = (XdmMap) processor.newXPathCompiler().evaluate(
                "let $games := stats/games/* return map { 'homeWinPercentages' : $games/team1_win_perc/number(), 'awayWinPercentages' : $games/team2_win_perc/number(), 'drawPercentages' : $games/draw_perc/number() }",
                inputDoc
        );

        System.out.println(result);
    }
}

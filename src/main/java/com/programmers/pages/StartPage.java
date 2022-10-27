package com.programmers.pages;


import com.programmers.engine.parser.Parser;
import lombok.Builder;

public class StartPage extends Page<PageList> {


    @Builder
    public StartPage(String content, String prompt, PageList nextPage, Parser<PageList> parser) {
        super(content, prompt, nextPage, parser);
    }

    @Override
    public void render() {
        while (true) {
            String inputString;
            outputData(getContent());
            inputString = input(getPrompt());
            getParser().parseInput(inputString);
            try{
                PageList parsedInput = getParser().getParsedResultData();
                setNextPage(parsedInput);
                break;
            }catch (Exception e){
                this.error();
            }
        }

    }

}

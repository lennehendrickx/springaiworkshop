package com.lennehendrickx.springai.multimodal;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ImageGeneration {

    private final OpenAiImageModel imageModel;

    public ImageGeneration(OpenAiImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping("/generate-image")
    public ResponseEntity<Map<String, String>> generateImage(
            @RequestParam(defaultValue = "A beautiful sunset over mountains") String prompt
    ) {

        var imageOptions = OpenAiImageOptions
                .builder()
                .width(1024)
                .height(1024)
                .quality("hd")
                .style("vivid")
                .build();

        var imagePrompt = new ImagePrompt(prompt, imageOptions);
        var imageResponse = imageModel.call(imagePrompt);
        return ResponseEntity.ok(Map.of("url", imageResponse.getResult().getOutput().getUrl()));
    }
}

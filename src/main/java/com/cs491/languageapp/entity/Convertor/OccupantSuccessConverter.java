package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.OccupantSuccess;
import com.cs491.languageapp.entity.response.CreateOccupantSuccessResponse;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OccupantSuccessConverter {

    private final WordConverter wordConverter;
    private final OccupantConverter occupantConverter;

    public CreateOccupantSuccessResponse convert(OccupantSuccess occupantSuccess){
        if(occupantSuccess==null){
            return null;
        }

        return new CreateOccupantSuccessResponse
                (occupantSuccess.getId(),
                        occupantSuccess.isTrue(),
                        occupantSuccess.getLocalDateTime(),
                        wordConverter.convertWordResponse(occupantSuccess.getWord()),
                        occupantConverter.convertOccupantResponse(occupantSuccess.getOccupant()));
    }

    public List<CreateOccupantSuccessResponse> convert(List<OccupantSuccess> fromList){

        if (fromList==null){
            return null;
        }

        return fromList
                .stream()
                .map(occupantSuccess ->
                        new CreateOccupantSuccessResponse(
                                occupantSuccess.getId(),
                                occupantSuccess.isTrue(),
                                occupantSuccess.getLocalDateTime(),
                                wordConverter.convertWordResponse(occupantSuccess.getWord()),
                                occupantConverter.convertOccupantResponse(occupantSuccess.getOccupant())
                        )
                        ).collect(Collectors.toList());
    }
}

package com.koroot.user.api;

import com.koroot.user.model.NoticeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommunicationApiController {

    @GetMapping("/api/communication/noticeList")
    public List<NoticeDto> getNoticeAll(){
        List<NoticeDto> list = new ArrayList<>();
        for(int i=1;i<1000;i++){
            list.add(NoticeDto.of(i,String.valueOf(i),String.valueOf(i),String.valueOf(i)));
        }
        return list;
    }
}

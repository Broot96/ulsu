package com.example.ulsu.makeroom.responseDto;

import com.example.ulsu.makeroom.requestDto.BrdPageRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BrdPageResponse<E> {

    private int page;
    private int size;
    private int total;

    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> pageResponseList;

    @Builder(builderMethodName = "withAll")
    public BrdPageResponse(BrdPageRequest brdPageRequest, List<E> pageResponseList, int total){
        if(total <= 0){
            return;
        }

        this.page = brdPageRequest.getPage();
        this.size = brdPageRequest.getSize();

        this.total = total;
        this.pageResponseList = pageResponseList;

        this.end = (int)(Math.ceil(this.page/10.0))*10; //화면에서의 마지막 번호
        this.start = this.end-9;

        int last = (int)(Math.ceil((total/(double)size))); //데이터의 개수를 계산한 마지막 페이지 번호

        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;

    }
}

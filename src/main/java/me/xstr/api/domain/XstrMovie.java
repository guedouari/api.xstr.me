package me.xstr.api.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
public class XstrMovie {
	
    private long id;
    private String title;
    private String name;

}

package com.frank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 11:04 2019-12-09
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private List<AddressDto> children;
    private String name;
    private int pid;
    private int id;
}

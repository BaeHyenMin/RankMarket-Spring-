package com.market.rank.service.product;

import com.market.rank.dto.response.ResPrdDto;
import com.market.rank.dto.response.ResPrdMostDto;
import com.market.rank.dto.response.ResPrdPopDto;
import com.market.rank.dto.response.ResPrdsDto;
import com.market.rank.mapper.product.ProductViewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductViewService {

    private final ProductViewMapper productViewMapper;


    public List<ResPrdsDto> products(int offset, String usrId, String search) {

        return productViewMapper.productViews(usrId, offset, search);

    }


    public ResPrdDto product(int prd_id) {


        ResPrdDto resPrdDto = productViewMapper.productView(prd_id);

        List<String> fileIds = productViewMapper.prdImgs(prd_id);

        resPrdDto.setImgs(fileIds);

        return resPrdDto;

    }


    public List<ResPrdPopDto> prdPopular() {
        return productViewMapper.prdPopular();
    }


    public List<ResPrdMostDto> prdMost() {
        return productViewMapper.prdMost()
                .stream()
                .peek(it -> {
                    it.setImg(productViewMapper.prdImgs(it.getPrdId()));

                }).collect(Collectors.toList());

    }


}

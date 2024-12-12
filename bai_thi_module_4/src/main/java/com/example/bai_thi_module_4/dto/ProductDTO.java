package com.example.bai_thi_module_4.dto;

import com.example.bai_thi_module_4.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductDTO {
    private Integer id;

    @NotBlank(message = "Tên sản phẩm không được để trống.")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải có độ dài từ 5 đến 50 ký tự.")
    private String name;

    @Min(value = 100000, message = "Giá sản phẩm phải ít nhất là 100,000 VNĐ.")
    @NotNull(message = "giá sản phẩm không được để trống.")
    private int price;

    @NotBlank(message = "Trạng thái không được để trống.")
    private String status;

    @NotNull(message = "Loại sản phẩm không được để trống.")
    private Category category;
}


package fr.afcepf.al32.groupe2.ws.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchByShopResponseDto {

	private List<PromotionDto> promotionsDto;
	
	private List<ShopDto> shopDtos;

	public List<PromotionDto> getPromotionsDto() {
		return promotionsDto;
	}

	public void setPromotionsDto(List<PromotionDto> promotionsDto) {
		this.promotionsDto = promotionsDto;
	}

	public List<ShopDto> getShopDtos() {
		return shopDtos;
	}

	public void setShopDtos(List<ShopDto> shopDtos) {
		this.shopDtos = shopDtos;
	}
	
	

}

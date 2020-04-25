package com.app.gh.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.generic.endpoint.contract.BaseResponse;
import com.app.generic.persistence.validator.field.ValidationCheck;
import com.app.gh.persistence.dto.StoreDto;
import com.app.gh.service.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService service;
	
	@Value("${spring.application.name}")
    String appName;
	
	@GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "store/list";
    }
	
	@PostMapping("/")
	public ResponseEntity<BaseResponse> getAll() {

		List<StoreDto> list = service.getAllActive();

		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponse(list);
		return ResponseEntity.ok().body(baseResponse);

	}

	@PostMapping("/save")
	public ResponseEntity<BaseResponse> save(@RequestBody StoreDto request) {
		if (request != null) {
			ValidationCheck.hasValidate(request);
		}

		StoreDto dto = service.save(request);

		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponse(dto);
		return ResponseEntity.ok().body(baseResponse);

	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<BaseResponse> delete(@PathVariable("id") Long id) {

		service.remove(id);

		BaseResponse baseResponse = new BaseResponse();
		return ResponseEntity.ok().body(baseResponse);

	}

	@PostMapping("/get/{id}")
	public ResponseEntity<BaseResponse> get(@PathVariable("id") Long id) {

		StoreDto dto = service.getById(id);

		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setResponse(dto);
		return ResponseEntity.ok().body(baseResponse);

	}

	
}

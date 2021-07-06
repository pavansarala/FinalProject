package com.PharmacySupply.UserPortal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:9002/pharmacy/medical-representative-schedule-service", name = "medical-representative-schedule-service")
public interface RepresentativeFeign {


	@GetMapping("/RepSchedule/{scheduleStartDate}")
	public ResponseEntity<?> getRepSchedule(@RequestHeader(name = "Authorization") String token,
			@DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable("scheduleStartDate") String scheduleStartDate);

}
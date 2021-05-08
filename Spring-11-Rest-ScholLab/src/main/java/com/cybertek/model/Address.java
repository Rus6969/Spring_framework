package com.cybertek.model;

import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "teacher"}, ignoreUnknown = true)
// we will not show null values in payload
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity {
    private String street;
    private String country;
    private String state;
    private String city;


    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;

    private Integer currentTemperature;

    public Integer consumeTemp(String city) {
        RestTemplate restTemplate = new RestTemplate();

        String Base_url = "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";

        String uri = Base_url + city;

        Object currentWheather = restTemplate.getForObject(uri, Object.class);
        // we are casting here, reason is it will come as a json( will be returned from third party api)  key and value
        Map<String,Object>getweather = (Map<String,Object>) currentWheather;
        //we are using current here bc current is a key in 3partyapi its comming as a key
        Map<String,Object>getTemperature = (Map<String,Object>) getweather.get("current");
        //parsing to String since we want return in String, specific value from json
        return Integer.parseInt(getTemperature.get("temperature").toString());

    }

}

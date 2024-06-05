package com.example.productservice.services;

import com.example.productservice.clients.FakeStore.FakeStoreClient;
import com.example.productservice.clients.FakeStore.FakeStoreProductDto;
import com.example.productservice.dtos.ProductDto;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class FakeProductServiceImpl implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;

    public FakeProductServiceImpl(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient=fakeStoreClient;
    }

    @Override
    public List<Product> getProducts() {

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<FakeStoreProductDto> fakeStoreProductDtoList=fakeStoreClient.getProducts();
        List<Product> answer = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList) {
            answer.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return answer;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.getSingleProduct(productId);

        if(fakeStoreProductDto==null)
        {
            return Optional.empty();
        }
        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.addNewProduct(productDto);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
//        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
//
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto.setTitle(product.getTitle());
//        fakeStoreProductDto.setPrice(product.getPrice());
//        fakeStoreProductDto.setCategory(product.getCategory().getName());
//        fakeStoreProductDto.setImage(product.getImage());
//        fakeStoreProductDto.setDescription(product.getDescription());
//
//        ResponseEntity<FakeStoreProductDto> responseEntity =
//                requestForEntity(HttpMethod.PATCH, "https://fakestoreapi.com/products/{id}", fakeStoreProductDto, FakeStoreProductDto.class, productId);
        FakeStoreProductDto fakeStoreProductDto= fakeStoreClient.updateProduct(productId,product);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {

//        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
//
//        ResponseEntity<FakeStoreProductDto> responseEntity=requestForEntity(HttpMethod.DELETE,"https://fakestoreapi.com/products/{id}",null,FakeStoreProductDto.class,productId);
       FakeStoreProductDto fakeStoreProductDto= fakeStoreClient.deleteProduct(productId);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

    }

    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto)
    {

        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImage(fakeStoreProductDto.getImage());
      return product;
    }
}

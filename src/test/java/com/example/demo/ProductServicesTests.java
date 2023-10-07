package com.example.demo;

import com.example.demo.Models.Products;
import com.example.demo.Services.ProductService;
import com.example.demo.repos.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServicesTests {

        @Mock
        private ProductRepository productRepository;

        private ProductService productService;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
            productService = new ProductService(productRepository);
        }

        @Test
        void testGetAllProducts() {
            List<Products> mockProducts = new ArrayList<>();
            when(productRepository.findAll()).thenReturn(mockProducts);
            List<Products> result = productService.getAllProducts();
            assertEquals(mockProducts, result);
        }

        @Test
        void testSaveProduct() {
            Products mockProduct = new Products();
            when(productRepository.save(mockProduct)).thenReturn(mockProduct);
            Products result = productService.saveProduct(mockProduct);
            assertEquals(mockProduct, result);
        }

        @Test
        void testDeleteProduct() {
            Long productId = 1L;
            productService.deleteProduct(productId);
            verify(productRepository, times(1)).deleteById(productId);
        }
    }


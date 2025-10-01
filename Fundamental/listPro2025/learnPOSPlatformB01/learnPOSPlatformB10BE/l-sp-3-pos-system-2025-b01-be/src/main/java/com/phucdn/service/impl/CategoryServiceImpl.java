package com.phucdn.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import com.phucdn.model.Store;
import com.phucdn.model.User;
import com.phucdn.domain.UserRole;
import com.phucdn.mapper.CategoryMapper;
import com.phucdn.model.Category;
import com.phucdn.payload.dto.CategoryDto;
import com.phucdn.repository.CategoryRepository;
import com.phucdn.repository.StoreRepository;
import com.phucdn.service.CategoryService;
import com.phucdn.service.UserService;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final SecurityFilterChain securityFilterChain;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StoreRepository storeRepository;

    CategoryServiceImpl(SecurityFilterChain securityFilterChain) {
        this.securityFilterChain = securityFilterChain;
    }

	@Override
	public CategoryDto createCategory(CategoryDto dto) throws Exception {
		User user = userService.getCurrentUser();
		Store store = storeRepository.findById(dto.getStoreId()).orElseThrow(() -> new Exception("Store is not found!"));
		
		Category category = Category.builder()
				.store(store)
				.name(dto.getName())
				.build();
		
		checkAuthority(user, category.getStore());
		
		return CategoryMapper.toDto(categoryRepository.save(category));
	}

	@Override
	public List<CategoryDto> getCategoriesByStore(Long storeId) {
		List<Category> categories = categoryRepository.findAll();
		
		return categories.stream().map(CategoryMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public CategoryDto updateCategory(Long id, CategoryDto dto) throws Exception {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("Category not exist."));
		
		User user = userService.getCurrentUser();
		
		category.setName(dto.getName());
		
		checkAuthority(user, category.getStore());
	
		return CategoryMapper.toDto(categoryRepository.save(category));
		
	}

	@Override
	public void deleteCategory(Long id) throws Exception {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("Category not exist."));
		
		User user = userService.getCurrentUser();	
		
		checkAuthority(user, category.getStore());
		
		categoryRepository.delete(category);
	}
	
	private void checkAuthority(User user, Store store) throws Exception {
		boolean isAdmin = user.getRole().equals(UserRole.ROLE_STORE_ADMIN);
		boolean isManager = user.getRole().equals(UserRole.ROLE_STORE_MANAGER);
		
		boolean isSameStore = user.equals(store.getStoreAdmin());
		
		if (!(isAdmin && isSameStore) && !isManager) {
			throw new Exception("You don't have permission to manage this category.");
		}
	}
}

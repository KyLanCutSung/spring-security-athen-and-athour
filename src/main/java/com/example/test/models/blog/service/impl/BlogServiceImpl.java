package com.example.test.models.blog.service.impl;

import com.example.test.dtos.request.SignUpForm;
import com.example.test.entities.RoleEntity;
import com.example.test.entities.UserEntity;
import com.example.test.enums.RoleName;
import com.example.test.models.blog.dto.BlogDto;
import com.example.test.models.blog.entity.BlogEntity;
import com.example.test.models.blog.repo.BlogRepository;
import com.example.test.models.blog.service.BlogService;
import com.example.test.models.category.dto.CategoryDto;
import com.example.test.models.category.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private BlogEntity dto2Entity(BlogDto blogDto){
        BlogEntity blogEntity = modelMapper.map(blogDto, BlogEntity.class);
        return blogEntity;
    }
//    public void saveUser(BlogDto blogDto){
//        UserEntity userEntity = new UserEntity();
//        Set<String> strCategories = blogDto.getCategoryDtos();
//        Set<CategoryEntity> categoryEntities = new HashSet<>();
//        strCategories.forEach(category ->{
//            switch (category){
//                case "admin":
//                    RoleEntity adminRole = roleService.findByRoleName(RoleName.ADMIN.name()).orElseThrow(
//                            () -> new RuntimeException("Role not found")
//                    );
//                    roleEntities.add(adminRole);
//                    break;
//                case "pm":
//                    RoleEntity pmRole = roleService.findByRoleName(RoleName.PM.name()).orElseThrow(
//                            () -> new RuntimeException("Role not found")
//                    );
//                    roleEntities.add(pmRole);
//                    break;
//                default:
//                    RoleEntity userRole = roleService.findByRoleName(RoleName.USER.name()).orElseThrow(
//                            () -> new RuntimeException("Role not found")
//                    );
//                    roleEntities.add(userRole);
//            }
//        });
//        userEntity.setRoleEntities(roleEntities);
//        userService.save(userEntity);
//    }
}

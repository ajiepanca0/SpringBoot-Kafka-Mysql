package com.ajiepanca.springbootkafkarealworldprojectconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajiepanca.springbootkafkarealworldprojectconsumer.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}

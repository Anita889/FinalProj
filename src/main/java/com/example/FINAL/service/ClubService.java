package com.example.FINAL.service;

import com.example.FINAL.dto.ClubDto;
import com.example.FINAL.models.Club;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClub();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void delete(Long clubId);
    List<ClubDto> searchClubs(String query);
}

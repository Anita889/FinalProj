package com.example.FINAL.service.serviceimpl;

import com.example.FINAL.dto.ClubDto;
import com.example.FINAL.repository.ClubRepository;
import com.example.FINAL.service.ClubService;
import com.example.FINAL.models.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.FINAL.mapper.ClubMapper.maptoClub;
import static com.example.FINAL.mapper.ClubMapper.maptoClubDto;


@Service
public class ClubServiceImpl implements ClubService {
   private ClubRepository clubRepository;

   @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClub() {
        List<Club> clubs=clubRepository.findAll();
        return clubs.stream().map((club)->maptoClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club=maptoClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
       Club club=clubRepository.findById(clubId).get();
        return maptoClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club=maptoClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
       List<Club> clubs=clubRepository.searchClubs(query);
        return clubs.stream().map(club -> maptoClubDto(club)).collect(Collectors.toList());
    }

}

package com.example.FINAL.mapper;

import com.example.FINAL.dto.ClubDto;
import com.example.FINAL.models.Club;
import com.example.FINAL.models.Event;

import java.util.stream.Collectors;

import static com.example.FINAL.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static Club maptoClub(ClubDto clubDto) {
        Club club=Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdOn(clubDto.getCreatedOn())
                .updatedOnl(clubDto.getUpdatedOnl())
                .build();
        return club;
    }

    public static ClubDto maptoClubDto(Club club) {
        ClubDto clubDto=ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOnl(club.getUpdatedOnl())
                .events(club.getEvents().stream().map((event)->mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}

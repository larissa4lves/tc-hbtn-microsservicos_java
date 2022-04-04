package com.song.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
        public class SongRepository {
           private List<Song> list = new ArrayList<Song>();

           public List<Song> getAllSongs() {
            return list;
           }

           public Song getSongById(Integer id) {
              for (Song lista : list) {
				if(lista.getId().equals(id) ) {
					return lista;
				}
				
			}
              
              return null;
           }

           public void addSong(Song s) {
        	   list.add(s);
           }

           public void updateSong(Song s) {
        	   	for (Song lista : list) {
				  if(lista.getId().equals(s)) {
					  list.remove(s);
					  list.add(s);
				  }
				}
           }

           public void removeSong(Song s) {
        	   for (Song lista : list) {
				if(lista.getId().equals(s)) {
					list.remove(s);
				}
			}
           }
     }

package ru.itmo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.db.InternalItem;
import ru.itmo.db.ItemRepository;
import ru.itmo.db.RarityRepository;
import ru.itmo.db.TypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RarityRepository rarityRepository;
    @Autowired
    private TypeRepository typeRepository;

    public ItemService() {
    }

    public List<InternalItem> getUsersItems(String login) {
        if (itemRepository == null) return new ArrayList<>();
        return itemRepository.findByOwner(login);
    }

    public String getRarity(Integer rid) {
        if (rarityRepository == null || rarityRepository.findById(rid).isEmpty()) return "";
        return rarityRepository.findById(rid).get().getRarity();
    }

    public String getType(Integer tid) {
        if (typeRepository == null || typeRepository.findById(tid).isEmpty()) return "";
        return typeRepository.findById(tid).get().getType();
    }

    public Integer getRarityId(String rarity) {
        if (rarityRepository == null) return 0;
        return rarityRepository.findByRarity(rarity).getRid();
    }

    public Integer getTypeId(String type) {
        if (typeRepository == null) return 0;
        return typeRepository.findByType(type).getTid();
    }

    public InternalItem getItemById(Integer id) {
        if (itemRepository == null || itemRepository.findById(id).isEmpty()) return null;
        return itemRepository.findById(id).get();
    }

    public void removeOwner(Integer id) {
        if (itemRepository != null && itemRepository.findById(id).isPresent()) {
            InternalItem internalItem = itemRepository.findById(id).get();
            internalItem.setOwner("");
            itemRepository.save(internalItem);
        }
    }
}
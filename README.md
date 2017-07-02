# ![Genie](https://puu.sh/wzEu8/37c644db8a.jpg)

A Bukkit plugin for competition: https://www.spigotmc.org/threads/plugin-competition-started.252088/  
The theme of the competition is Magic.

Contains plugin framework:
- [BukkitPluginDependency](https://github.com/Rsl1122/BukkitPluginDependency)

## ![Features](http://puu.sh/wzEu4/fd4115d518.jpg)

- Adds a genie lamp that is dropped by mobs in the desert (1 / 400) & more rarely outside (1 / 5000)
(These drop rates are adjustable in the config)
- Lamp has 3 wishes.
- Anyone holding the lamp can wish whatever they want in the chat. The plugin then attempts to match a wish with the message.
- Admin command /genie for giving lamps & testing wishes.

### Currently available wishes:
- Almost any mob
- Almost any mob riding any other mob ("mob on mob")
- Almost any item
- Weather changes
- Explosion
- Pets such as Dog & Cat. 
- Animals, Farm, Food, Armor

The plugin removes extra words that do not hold information about the wish.  
**Example**: "I wish I had a pig that was riding on a cow" -> "pig riding on cow" -> Matches wish: SpawnMobRidingOn Cow, Pig

### Planned wishes:
- Flying
- Being a ghost
- Assasination
- Teleportation (To player, bed or last death location)
- Any other wishes that come to mind
- Suggestions after plugin is released
- Unanswered wishes lists generated by the plugin
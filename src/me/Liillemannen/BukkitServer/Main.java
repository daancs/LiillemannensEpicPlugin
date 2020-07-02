package me.Liillemannen.BukkitServer;



import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    public GodBoots godboots = new GodBoots();
    public Trident trident = new Trident();
    public ChangeTeam changeteam = new ChangeTeam();


    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(godboots, this);
        this.getServer().getPluginManager().registerEvents(trident, this);
        this.getCommand("Launch").setExecutor(new Launch());
        this.getCommand("Hello").setExecutor(new Hello());
        this.getCommand("Doctor").setExecutor(new Heal());
        this.getCommand("Refill").setExecutor(new Refill());
        this.getCommand("gm").setExecutor(new Gamemode());
        this.getCommand("GodBoots").setExecutor(new GodBoots());
        this.getCommand("Trident").setExecutor(new Trident());
        this.getServer().getPluginManager().registerEvents(changeteam, this);
        this.getCommand("Changeteam").setExecutor(new ChangeTeam());
    }

    @Override
    public void onDisable() {

    }

}

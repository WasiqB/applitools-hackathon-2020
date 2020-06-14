package com.github.wasiqb.applitools.pages;

import static com.github.wasiqb.applitools.utils.ReporterUtil.log;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.wasiqb.applitools.utils.DriverUtil;
import com.github.wasiqb.applitools.utils.ElementUtil;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    public DashboardPage (final DriverUtil driverUtil) {
        super (driverUtil);
    }

    public ElementUtil banner () {
        return this.driverUtil.find (By.className ("top_banner"));
    }

    public ElementUtil cartIcon () {
        return this.driverUtil.find (By.id ("A__cartbt__49"));
    }

    public ElementUtil colorsFilter (final String color) {
        final Optional<ElementUtil> filter = this.driverUtil.finds (
            By.cssSelector ("div#sidebar_filters div.filter_type:nth-child(2) div#filter_1 ul li label"))
            .stream ()
            .filter (e -> e.text ()
                .startsWith (color))
            .findFirst ();
        return filter.orElse (null);
    }

    public ElementUtil detailViewIcon () {
        return this.driverUtil.find (By.className ("ti-view-list"));
    }

    public ElementUtil filterButton () {
        return this.driverUtil.find (By.id ("filterBtn"));
    }

    public void filterByColor (final String color) {
        if (filterOption ().isVisible ()) {
            filterOption ().click ();
        }
        colorsFilter (color).click ();
        filterButton ().click ();
    }

    public ElementUtil filterLabel () {
        return this.driverUtil.find (By.cssSelector ("a.open_filters > span"));
    }

    public ElementUtil filterOption () {
        return this.driverUtil.find (By.id ("ti-filter"));
    }

    public FooterSection footer () {
        return new FooterSection (this.driverUtil.find (By.tagName ("footer")));
    }

    public List<ElementUtil> items () {
        return this.driverUtil.finds (By.className ("grid_item"));
    }

    public ElementUtil logo () {
        return this.driverUtil.find (By.id ("logo"));
    }

    public ElementUtil mainMenu () {
        return this.driverUtil.find (By.id ("DIV__mainmenu__15"));
    }

    public ElementUtil productGrid () {
        return this.driverUtil.find (By.id ("product_grid"));
    }

    public List<ProductItem> productItems () {
        return productGrid ().finds (By.className ("grid_item"))
            .stream ()
            .map (ProductItem::new)
            .collect (Collectors.toList ());
    }

    public ElementUtil profileIcon () {
        return this.driverUtil.find (By.id ("A__accesslink__56"));
    }

    public ElementUtil searchBox () {
        return this.driverUtil.find (By.id ("INPUTtext____42"));
    }

    public ElementUtil searchIcon () {
        return this.driverUtil.find (By.id ("I__headericon__44"));
    }

    public ElementUtil sidebarFilters () {
        return this.driverUtil.find (By.id ("sidebar_filters"));
    }

    public ElementUtil sort () {
        return this.driverUtil.find (By.id ("sort"));
    }

    public ElementUtil tileViewIcon () {
        return this.driverUtil.find (By.className ("ti-view-grid"));
    }

    public void verifyLaptopView (final int version, final int taskId, final String browser, final String viewport,
        final String device) {
        log (version, taskId, "Main menu", mainMenu (), browser, viewport, device, true);
        log (version, taskId, "Search box", searchBox (), browser, viewport, device, true);
        log (version, taskId, "Search icon", searchIcon (), browser, viewport, device, true);
        log (version, taskId, "Tile view icon", tileViewIcon (), browser, viewport, device, true);
        log (version, taskId, "Detail view icon", detailViewIcon (), browser, viewport, device, true);
        log (version, taskId, "Cart icon", cartIcon (), browser, viewport, device, true);
        log (version, taskId, "Profile icon", profileIcon (), browser, viewport, device, true);
        log (version, taskId, "Wishlist icon", wishlistIcon (), browser, viewport, device, true);
        log (version, taskId, "Sidebar", sidebarFilters (), browser, viewport, device, true);
        log (version, taskId, "Filter option", filterOption (), browser, viewport, device, false);
        log (version, taskId, "Filter button", filterButton (), browser, viewport, device, true);
        log (version, taskId, "Filter Label", filterLabel (), browser, viewport, device, false);
        log (version, taskId, "Banner", banner (), browser, viewport, device, true);
        log (version, taskId, "Logo", logo (), browser, viewport, device, true);
        log (version, taskId, "Sort", sort (), browser, viewport, device, true);
        productItems ().forEach (e -> e.verifyLaptopView (version, taskId, browser, viewport, device));
        footer ().verifyLaptopTabletView (version, taskId, browser, viewport, device);
    }

    public void verifyMobileView (final int version, final int taskId, final String browser, final String viewport,
        final String device) {
        log (version, taskId, "Main menu", mainMenu (), browser, viewport, device, false);
        log (version, taskId, "Search box", searchBox (), browser, viewport, device, true);
        log (version, taskId, "Search icon", searchIcon (), browser, viewport, device, true);
        log (version, taskId, "Tile view icon", tileViewIcon (), browser, viewport, device, false);
        log (version, taskId, "Detail view icon", detailViewIcon (), browser, viewport, device, false);
        log (version, taskId, "Cart icon", cartIcon (), browser, viewport, device, true);
        log (version, taskId, "Profile icon", profileIcon (), browser, viewport, device, true);
        log (version, taskId, "Wishlist icon", wishlistIcon (), browser, viewport, device, false);
        log (version, taskId, "Sidebar", sidebarFilters (), browser, viewport, device, false);
        log (version, taskId, "Filter option", filterOption (), browser, viewport, device, true);
        log (version, taskId, "Filter button", filterButton (), browser, viewport, device, false);
        log (version, taskId, "Filter Label", filterLabel (), browser, viewport, device, false);
        log (version, taskId, "Banner", banner (), browser, viewport, device, true);
        log (version, taskId, "Logo", logo (), browser, viewport, device, true);
        log (version, taskId, "Sort", sort (), browser, viewport, device, true);
        productItems ().forEach (e -> e.verifyMobileView (version, taskId, browser, viewport, device));
        footer ().verifyMobileView (version, taskId, browser, viewport, device);
    }

    public void verifyTabletView (final int version, final int taskId, final String browser, final String viewport,
        final String device) {
        log (version, taskId, "Main menu", mainMenu (), browser, viewport, device, false);
        log (version, taskId, "Search box", searchBox (), browser, viewport, device, true);
        log (version, taskId, "Search icon", searchIcon (), browser, viewport, device, true);
        log (version, taskId, "Tile view icon", tileViewIcon (), browser, viewport, device, false);
        log (version, taskId, "Detail view icon", detailViewIcon (), browser, viewport, device, false);
        log (version, taskId, "Cart icon", cartIcon (), browser, viewport, device, true);
        log (version, taskId, "Profile icon", profileIcon (), browser, viewport, device, true);
        log (version, taskId, "Wishlist icon", wishlistIcon (), browser, viewport, device, false);
        log (version, taskId, "Sidebar", sidebarFilters (), browser, viewport, device, false);
        log (version, taskId, "Filter option", filterOption (), browser, viewport, device, true);
        log (version, taskId, "Filter button", filterButton (), browser, viewport, device, false);
        log (version, taskId, "Filter Label", filterLabel (), browser, viewport, device, true);
        log (version, taskId, "Banner", banner (), browser, viewport, device, true);
        log (version, taskId, "Logo", logo (), browser, viewport, device, true);
        log (version, taskId, "Sort", sort (), browser, viewport, device, true);
        productItems ().forEach (e -> e.verifyMobileView (version, taskId, browser, viewport, device));
        footer ().verifyLaptopTabletView (version, taskId, browser, viewport, device);
    }

    public ElementUtil wishlistIcon () {
        return this.driverUtil.find (By.id ("A__wishlist__52"));
    }
}
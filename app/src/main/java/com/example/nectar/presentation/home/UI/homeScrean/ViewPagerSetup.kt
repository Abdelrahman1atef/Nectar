package com.example.nectar.presentation.home.UI.homeScrean

import android.content.Context
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.nectar.R
import com.example.nectar.presentation.home.adapter.BannerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// Function to set up the ViewPager2 and TabLayout
fun setupViewPagerAndTabLayout(
    viewPager: ViewPager2,
    tabLayout: TabLayout,
    context: Context
) {
    // Image URLs for the banners
    val images = listOf(
        "https://student.valuxapps.com/storage/uploads/banners/1689106932hsRxm.photo_2023-07-11_23-07-53.png",
        "https://student.valuxapps.com/storage/uploads/banners/1689106904Mzsmc.photo_2023-07-11_23-08-24.png",
        "https://student.valuxapps.com/storage/uploads/banners/1689108280StVEo.cyber-monday-banner-template_23-2148748266 (1).png",
        "https://student.valuxapps.com/storage/uploads/banners/1689108526i90RV.online-shopping-banner-template_23-2148764566 (1).png"
    )

    // Set up the adapter with the image URLs
    val bannerAdapter = BannerAdapter()
    bannerAdapter.setData(images)
    viewPager.adapter = bannerAdapter

    // Setup TabLayout with ViewPager2
    TabLayoutMediator(tabLayout, viewPager) { tab, _ ->
        tab.setIcon(R.drawable.dot) // Set default dot icon
    }.attach()

    // Update tab colors and margins on page change
    viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            // Reset all dots to default icon (unselected state)
            for (i in 0 until tabLayout.tabCount) {
                val tab = tabLayout.getTabAt(i)
                tab?.icon = ContextCompat.getDrawable(context, R.drawable.dot) // Default dot
            }

            // Set the selected dot to the larger, green dot
            val selectedTab = tabLayout.getTabAt(position)
            selectedTab?.icon = ContextCompat.getDrawable(context, R.drawable.dot_selected)

            // Adjust the margin between dots
            val tabStrip = tabLayout.getChildAt(0) as ViewGroup
            for (i in 0 until tabStrip.childCount) {
                val tabView = tabStrip.getChildAt(i) as ViewGroup
                val layoutParams = tabView.layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(5, 0, 5, 0) // Set margin between tabs (adjust as needed)
                tabView.requestLayout() // Ensure the layout updates
            }
        }
    })
}

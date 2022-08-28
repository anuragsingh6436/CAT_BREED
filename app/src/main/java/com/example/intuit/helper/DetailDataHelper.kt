package com.example.intuit.helper

import com.example.intuit.BR
import com.example.intuit.R
import com.example.intuit.base.LinearLayoutItemData
import com.example.intuit.constants.Constants
import com.example.intuit.dataModel.RatingItemModel
import com.example.intuit.model.response.BreedData
import javax.inject.Inject

class DetailDataHelper @Inject constructor() {

    fun getRatingItems(breedData: BreedData): List<LinearLayoutItemData> {
        //affection level
        val ratingList = arrayListOf<LinearLayoutItemData>()
        breedData.affection_level?.let {
            ratingList.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.AFFECTION_LEVEL, it)
                )
            )
        }
        //child friendly
        breedData.child_friendly?.let {
            ratingList.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.CHILD_FRIENDLY, it)
                )
            )
        }
        //dog friendly
        breedData.dog_friendly?.let {
            ratingList.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.DOG_FRIENDLY, it)
                )
            )
        }
        //energy level
        breedData.energy_level?.let {
            ratingList.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.ENERGY_LEVEL, it)
                )
            )
        }
        //health issues
        breedData.health_issues?.let {
            ratingList.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.HEALTH_ISSUES, it)
                )
            )
        }
        //intelligence
        breedData.intelligence?.let {
            ratingList.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.INTELLIGENCE, it)
                )
            )
        }
        //social needs
        breedData.social_needs?.let {
            ratingList.add(
                LinearLayoutItemData(
                    R.layout.detail_rating_items,
                    BR.model,
                    RatingItemModel(Constants.SOCIAL_NEEDS, it)
                )
            )
        }
        return ratingList
    }
}
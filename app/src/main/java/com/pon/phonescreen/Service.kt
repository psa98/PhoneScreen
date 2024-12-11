package com.pon.phonescreen

import android.telecom.Call
import android.telecom.CallScreeningService
import android.widget.Toast

class ScreeningService : CallScreeningService() {
    override fun onScreenCall(callDetails: Call.Details) {
        val isIncoming = callDetails.callDirection == Call.Details.DIRECTION_INCOMING
        val handle = callDetails.handle

        if (isIncoming) {
            Toast.makeText(this, handle.toString(), Toast.LENGTH_LONG).show()
        }


        val response = CallResponse.Builder()
        // Sets whether the incoming call should be blocked.
        response.setDisallowCall(false)
        // Sets whether the incoming call should be rejected as if the user did so manually.
        response.setRejectCall(false)
        // Sets whether ringing should be silenced for the incoming call.
        response.setSilenceCall(false)
        // Sets whether the incoming call should not be displayed in the call log.
        response.setSkipCallLog(false)
        // Sets whether a missed call notification should not be shown for the incoming call.
        response.setSkipNotification(false)

        // Call this function to provide your screening response.
        respondToCall(callDetails, response.build())
    }
}

package component.instrument

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.text.TextUtils
import android.util.Log
import component.instrument.proguard.BaseProguardString

class DeviceKeyMonitor(private val mContext: Context, private val mListener: OnKeyListener) {

    private var melding: BroadcastReceiver? = null//T003mDeviceKeyReceiver  melding  melding:

    //Home
    init {
        melding = object : BroadcastReceiver() {//T003mDeviceKeyReceiver  melding  melding 
            override fun onReceive(context: Context, intent: Intent) {
                if (intent != null && intent.action == Intent.ACTION_CLOSE_SYSTEM_DIALOGS) {


                    var _fulvous:Int = 6077;//
                    repelled(_fulvous);//

                    var _carucage:String = "parpen";//
                    pyemesis(_carucage);//
                    val reason = intent.getStringExtra(BaseProguardString.SYSTEM_REASON)


                    var _fidate:String = "canons";//
                    bonos(_fidate);//

                    var _acumble:Int = 2934;//
                    enceint(_acumble);//

                    var _neese:Long = 9046;//
                    equites(_neese);//

                    var _conplane:Int = 1383;//
                    gashly(_conplane);//
                    if (!TextUtils.isEmpty(reason)) {


                        var _inkosi:String = "cotwist";//
                        crosser(_inkosi);//
                        if (BaseProguardString.SYSTEM_HOME_KEY == reason) {
                            mListener.onHomeClick()
                        } else if (BaseProguardString.SYSTEM_HOME_RECENT_APPS == reason) {
                            mListener.onRecentClick()
                        }


                        var _upshear:Int = 3266;//
                        talose(_upshear);//

                        var _unjagged:Int = 1515;//
                        bangled(_unjagged);//
                    }
                }
            }
        }
    }
    /**
     * 
     */
    fun gashly(mocuck:Int) :Int{
        var mocuck1=mocuck+68225;
        return mocuck;
    }

    /**
     * 
     */
    fun bangled(stivers:Int) :Int{
        var stivers1=stivers+80338;
        return stivers;
    }

    /**
     * 
     */
    fun pyemesis(escence:String) :String{
        var  escence1 = escence + "neebor";
        return escence1;
    }

    /**
     * 
     */
    fun enceint(defamed:Int) :Int{
        var defamed1=defamed+58176;
        return defamed;
    }

    /**
     * 
     */
    fun equites(talking:Long) :Long{
        var talking1=talking+47813;
        return talking;
    }

    /**
     * 
     */
    fun talose(hookshop:Int) :Int{
        var hookshop1=hookshop+2211;
        return hookshop;
    }

    /**
     * 
     */
    fun repelled(missions:Int) :Int{
        var missions1=missions+47998;
        return missions;
    }

    /**
     * 
     */
    fun bonos(sapours:String) :String{
        var  sapours1 = sapours + "uzaron";
        return sapours1;
    }

    /**
     * 
     */
    fun crosser(jambo:String) :String{
        var  jambo1 = jambo + "lahar";
        return jambo1;
    }


    interface OnKeyListener {
        fun onHomeClick()
        fun onRecentClick()
    }

    fun register() {
        safeRun {
            mContext.registerReceiver(
                melding, IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)//T003mDeviceKeyReceiver  melding  melding,
            )
        }
    }

    fun unregister() {
        safeRun {
            if (melding != null) {//T003mDeviceKeyReceiver  melding (melding 
                mContext.unregisterReceiver(melding)//T003mDeviceKeyReceiver  melding (melding)
                melding = null//T003mDeviceKeyReceiver  melding  melding 
            }
        }
    }

}

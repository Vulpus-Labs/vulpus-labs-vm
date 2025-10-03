package com.vulpuslabs.distributor;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.distributor.*;
import com.vulpuslabs.vulpes.values.events.EventBus;
import com.vulpuslabs.vulpes.values.events.UIEventHandler;
import com.vulpuslabs.vulpes.values.inputs.TriggerInput;
import java.util.function.DoubleConsumer;


//[/user-imports]


public class Distributor extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Distributor( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Distributor", ModuleType.ModuleType_Utility, 2.6 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "d0ab928ba49d4dc18abf4b6b309a8d48" );
   }

void InitializeControls()
{

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "DISTRIBUTOR" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 0 );
      textLabel1.SetSize( 187, 15 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 1 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "VULPUS LABS" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 345 );
      textLabel2.SetSize( 187, 15 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 1 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "TRIG IN" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 4, 54 );
      textLabel3.SetSize( 35, 15 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "GATE OUT" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 4, 198 );
      textLabel4.SetSize( 35, 25 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( true );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "0" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 8, 150 );
      textLabel5.SetSize( 25, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( false );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "Arial", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "1" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 44, 114 );
      textLabel6.SetSize( 25, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 10, true, false );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "2" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 80, 78 );
      textLabel7.SetSize( 25, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "3" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 116, 42 );
      textLabel8.SetSize( 25, 15 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 10, true, false );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "4" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 152, 6 );
      textLabel9.SetSize( 25, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "GATE" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 2, 298 );
      textLabel10.SetSize( 35, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "DELAY" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 40, 298 );
      textLabel11.SetSize( 35, 15 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "JIT" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 74, 319 );
      textLabel12.SetSize( 20, 15 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( false );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "Arial", 10, true, false );

      gateOut01 = new VoltageAudioJack( "gateOut01", "Gate Out 0.1", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut01 );
      gateOut01.SetWantsMouseNotifications( false );
      gateOut01.SetPosition( 8, 168 );
      gateOut01.SetSize( 25, 25 );
      gateOut01.SetSkin( "Jack Round Cream Ring" );

      gateOut22 = new VoltageAudioJack( "gateOut22", "Gate Out 2.2", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut22 );
      gateOut22.SetWantsMouseNotifications( false );
      gateOut22.SetPosition( 80, 168 );
      gateOut22.SetSize( 25, 25 );
      gateOut22.SetSkin( "Jack Round Mint Ring" );

      gateOut12 = new VoltageAudioJack( "gateOut12", "Gate Out 1.2", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut12 );
      gateOut12.SetWantsMouseNotifications( false );
      gateOut12.SetPosition( 44, 204 );
      gateOut12.SetSize( 25, 25 );
      gateOut12.SetSkin( "Jack Round Cherry Ring" );

      distribution21 = new VoltageKnob( "distribution21", "Distribution 2.1", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution21 );
      distribution21.SetWantsMouseNotifications( false );
      distribution21.SetPosition( 80, 132 );
      distribution21.SetSize( 27, 27 );
      distribution21.SetSkin( "Plastic Mint" );
      distribution21.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution21.SetKnobParams( 215, 145 );
      distribution21.DisplayValueInPercent( false );
      distribution21.SetKnobAdjustsRing( true );

      gateOut11 = new VoltageAudioJack( "gateOut11", "Gate Out 1.1", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut11 );
      gateOut11.SetWantsMouseNotifications( false );
      gateOut11.SetPosition( 44, 132 );
      gateOut11.SetSize( 25, 25 );
      gateOut11.SetSkin( "Jack Round Cherry Ring" );

      gateOut21 = new VoltageAudioJack( "gateOut21", "Gate Out 2.1", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut21 );
      gateOut21.SetWantsMouseNotifications( false );
      gateOut21.SetPosition( 80, 94 );
      gateOut21.SetSize( 25, 25 );
      gateOut21.SetSkin( "Jack Round Mint Ring" );

      gateLengthKnob = new VoltageKnob( "gateLengthKnob", "Gate Length", this, 0.0, 1.0, 0.25 );
      AddComponent( gateLengthKnob );
      gateLengthKnob.SetWantsMouseNotifications( false );
      gateLengthKnob.SetPosition( 8, 271 );
      gateLengthKnob.SetSize( 27, 27 );
      gateLengthKnob.SetSkin( "Plastic Orange" );
      gateLengthKnob.SetRange( 0.0, 1.0, 0.25, false, 0 );
      gateLengthKnob.SetKnobParams( 215, 145 );
      gateLengthKnob.SetUnits( "s" );
      gateLengthKnob.DisplayValueInPercent( false );
      gateLengthKnob.SetKnobAdjustsRing( true );
      gateLengthKnob.SetMidpointValue( 0.25 );

      delayLengthKnob = new VoltageKnob( "delayLengthKnob", "Delay", this, 0.0, 1.0, 0 );
      AddComponent( delayLengthKnob );
      delayLengthKnob.SetWantsMouseNotifications( false );
      delayLengthKnob.SetPosition( 44, 271 );
      delayLengthKnob.SetSize( 27, 27 );
      delayLengthKnob.SetSkin( "Plastic Orange" );
      delayLengthKnob.SetRange( 0.0, 1.0, 0, false, 0 );
      delayLengthKnob.SetKnobParams( 215, 145 );
      delayLengthKnob.SetUnits( "s" );
      delayLengthKnob.DisplayValueInPercent( false );
      delayLengthKnob.SetKnobAdjustsRing( true );

      distribution11 = new VoltageKnob( "distribution11", "Distribution 1.1", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution11 );
      distribution11.SetWantsMouseNotifications( false );
      distribution11.SetPosition( 44, 168 );
      distribution11.SetSize( 27, 27 );
      distribution11.SetSkin( "Plastic Cherry" );
      distribution11.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution11.SetKnobParams( 215, 145 );
      distribution11.DisplayValueInPercent( false );
      distribution11.SetKnobAdjustsRing( true );

      delayJitterKnob = new VoltageKnob( "delayJitterKnob", "Delay Jitter", this, 0.0, 1.0, 0 );
      AddComponent( delayJitterKnob );
      delayJitterKnob.SetWantsMouseNotifications( false );
      delayJitterKnob.SetPosition( 44, 315 );
      delayJitterKnob.SetSize( 27, 27 );
      delayJitterKnob.SetSkin( "Plastic Orange" );
      delayJitterKnob.SetRange( 0.0, 1.0, 0, false, 0 );
      delayJitterKnob.SetKnobParams( 215, 145 );
      delayJitterKnob.DisplayValueInPercent( true );
      delayJitterKnob.SetKnobAdjustsRing( true );

      gateOut23 = new VoltageAudioJack( "gateOut23", "Gate Out 2.3", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut23 );
      gateOut23.SetWantsMouseNotifications( false );
      gateOut23.SetPosition( 80, 240 );
      gateOut23.SetSize( 25, 25 );
      gateOut23.SetSkin( "Jack Round Mint Ring" );

      distribution22 = new VoltageKnob( "distribution22", "Distribution 2.2", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution22 );
      distribution22.SetWantsMouseNotifications( false );
      distribution22.SetPosition( 80, 204 );
      distribution22.SetSize( 27, 27 );
      distribution22.SetSkin( "Plastic Mint" );
      distribution22.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution22.SetKnobParams( 215, 145 );
      distribution22.DisplayValueInPercent( false );
      distribution22.SetKnobAdjustsRing( true );

      gateOut32 = new VoltageAudioJack( "gateOut32", "Gate Out 3.2", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut32 );
      gateOut32.SetWantsMouseNotifications( false );
      gateOut32.SetPosition( 116, 132 );
      gateOut32.SetSize( 25, 25 );
      gateOut32.SetSkin( "Jack Round Sky Ring" );

      gateOut31 = new VoltageAudioJack( "gateOut31", "Gate Out 3.1", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut31 );
      gateOut31.SetWantsMouseNotifications( false );
      gateOut31.SetPosition( 116, 61 );
      gateOut31.SetSize( 25, 25 );
      gateOut31.SetSkin( "Jack Round Sky Ring" );

      gateOut33 = new VoltageAudioJack( "gateOut33", "Gate Out 3.3", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut33 );
      gateOut33.SetWantsMouseNotifications( false );
      gateOut33.SetPosition( 116, 204 );
      gateOut33.SetSize( 25, 25 );
      gateOut33.SetSkin( "Jack Round Sky Ring" );

      distribution31 = new VoltageKnob( "distribution31", "Distribution 3.1", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution31 );
      distribution31.SetWantsMouseNotifications( false );
      distribution31.SetPosition( 116, 93 );
      distribution31.SetSize( 27, 27 );
      distribution31.SetSkin( "Plastic Blue" );
      distribution31.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution31.SetKnobParams( 215, 145 );
      distribution31.DisplayValueInPercent( false );
      distribution31.SetKnobAdjustsRing( true );

      distribution32 = new VoltageKnob( "distribution32", "Distribution 3.2", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution32 );
      distribution32.SetWantsMouseNotifications( false );
      distribution32.SetPosition( 116, 168 );
      distribution32.SetSize( 27, 27 );
      distribution32.SetSkin( "Plastic Blue" );
      distribution32.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution32.SetKnobParams( 215, 145 );
      distribution32.DisplayValueInPercent( false );
      distribution32.SetKnobAdjustsRing( true );

      gateOut34 = new VoltageAudioJack( "gateOut34", "Gate Out 3.4", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut34 );
      gateOut34.SetWantsMouseNotifications( false );
      gateOut34.SetPosition( 116, 276 );
      gateOut34.SetSize( 25, 25 );
      gateOut34.SetSkin( "Jack Round Sky Ring" );

      distribution33 = new VoltageKnob( "distribution33", "Distribution 3.3", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution33 );
      distribution33.SetWantsMouseNotifications( false );
      distribution33.SetPosition( 116, 240 );
      distribution33.SetSize( 27, 27 );
      distribution33.SetSkin( "Plastic Blue" );
      distribution33.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution33.SetKnobParams( 215, 145 );
      distribution33.DisplayValueInPercent( false );
      distribution33.SetKnobAdjustsRing( true );

      gateOut42 = new VoltageAudioJack( "gateOut42", "Gate Out 4.2", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut42 );
      gateOut42.SetWantsMouseNotifications( false );
      gateOut42.SetPosition( 152, 96 );
      gateOut42.SetSize( 25, 25 );
      gateOut42.SetSkin( "Jack Round Plum Ring" );

      gateOut41 = new VoltageAudioJack( "gateOut41", "Gate Out 4.1", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut41 );
      gateOut41.SetWantsMouseNotifications( false );
      gateOut41.SetPosition( 152, 24 );
      gateOut41.SetSize( 25, 25 );
      gateOut41.SetSkin( "Jack Round Plum Ring" );

      gateOut43 = new VoltageAudioJack( "gateOut43", "Gate Out 4.3", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut43 );
      gateOut43.SetWantsMouseNotifications( false );
      gateOut43.SetPosition( 152, 168 );
      gateOut43.SetSize( 25, 25 );
      gateOut43.SetSkin( "Jack Round Plum Ring" );

      gateOut44 = new VoltageAudioJack( "gateOut44", "Gate Out 4.4", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut44 );
      gateOut44.SetWantsMouseNotifications( false );
      gateOut44.SetPosition( 152, 239 );
      gateOut44.SetSize( 25, 25 );
      gateOut44.SetSkin( "Jack Round Plum Ring" );

      distribution42 = new VoltageKnob( "distribution42", "Distribution 4.2", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution42 );
      distribution42.SetWantsMouseNotifications( false );
      distribution42.SetPosition( 152, 132 );
      distribution42.SetSize( 27, 27 );
      distribution42.SetSkin( "Plastic Plum" );
      distribution42.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution42.SetKnobParams( 215, 145 );
      distribution42.DisplayValueInPercent( false );
      distribution42.SetKnobAdjustsRing( true );

      distribution41 = new VoltageKnob( "distribution41", "Distribution 4.1", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution41 );
      distribution41.SetWantsMouseNotifications( false );
      distribution41.SetPosition( 152, 60 );
      distribution41.SetSize( 27, 27 );
      distribution41.SetSkin( "Plastic Plum" );
      distribution41.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution41.SetKnobParams( 215, 145 );
      distribution41.DisplayValueInPercent( false );
      distribution41.SetKnobAdjustsRing( true );

      distribution43 = new VoltageKnob( "distribution43", "Distribution 4.3", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution43 );
      distribution43.SetWantsMouseNotifications( false );
      distribution43.SetPosition( 152, 204 );
      distribution43.SetSize( 27, 27 );
      distribution43.SetSkin( "Plastic Plum" );
      distribution43.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution43.SetKnobParams( 215, 145 );
      distribution43.DisplayValueInPercent( false );
      distribution43.SetKnobAdjustsRing( true );

      gateOut45 = new VoltageAudioJack( "gateOut45", "Gate Out 4.5", this, JackType.JackType_AudioOutput );
      AddComponent( gateOut45 );
      gateOut45.SetWantsMouseNotifications( false );
      gateOut45.SetPosition( 152, 312 );
      gateOut45.SetSize( 25, 25 );
      gateOut45.SetSkin( "Jack Round Plum Ring" );

      distribution44 = new VoltageKnob( "distribution44", "Distribution 4.4", this, 0.0, 1.0, 0.5 );
      AddComponent( distribution44 );
      distribution44.SetWantsMouseNotifications( false );
      distribution44.SetPosition( 152, 276 );
      distribution44.SetSize( 27, 27 );
      distribution44.SetSkin( "Plastic Plum" );
      distribution44.SetRange( 0.0, 1.0, 0.5, false, 0 );
      distribution44.SetKnobParams( 215, 145 );
      distribution44.DisplayValueInPercent( false );
      distribution44.SetKnobAdjustsRing( true );

      led11 = new VoltageLED( "led11", "LED 1.1", this );
      AddComponent( led11 );
      led11.SetWantsMouseNotifications( false );
      led11.SetPosition( 66, 124 );
      led11.SetSize( 11, 11 );
      led11.SetSkin( "Red" );

      led12 = new VoltageLED( "led12", "LED 1.2", this );
      AddComponent( led12 );
      led12.SetWantsMouseNotifications( false );
      led12.SetPosition( 66, 196 );
      led12.SetSize( 11, 11 );
      led12.SetSkin( "Red" );

      led32 = new VoltageLED( "led32", "LED 3.2", this );
      AddComponent( led32 );
      led32.SetWantsMouseNotifications( false );
      led32.SetPosition( 138, 124 );
      led32.SetSize( 11, 11 );
      led32.SetSkin( "Red" );

      led33 = new VoltageLED( "led33", "LED 3.3", this );
      AddComponent( led33 );
      led33.SetWantsMouseNotifications( false );
      led33.SetPosition( 138, 196 );
      led33.SetSize( 11, 11 );
      led33.SetSkin( "Red" );

      led43 = new VoltageLED( "led43", "LED 4.3", this );
      AddComponent( led43 );
      led43.SetWantsMouseNotifications( false );
      led43.SetPosition( 174, 160 );
      led43.SetSize( 11, 11 );
      led43.SetSkin( "Red" );

      led22 = new VoltageLED( "led22", "LED 2.2", this );
      AddComponent( led22 );
      led22.SetWantsMouseNotifications( false );
      led22.SetPosition( 102, 160 );
      led22.SetSize( 11, 11 );
      led22.SetSkin( "Red" );

      led21 = new VoltageLED( "led21", "LED 2.1", this );
      AddComponent( led21 );
      led21.SetWantsMouseNotifications( false );
      led21.SetPosition( 102, 88 );
      led21.SetSize( 11, 11 );
      led21.SetSkin( "Red" );

      led42 = new VoltageLED( "led42", "LED 4.2", this );
      AddComponent( led42 );
      led42.SetWantsMouseNotifications( false );
      led42.SetPosition( 174, 88 );
      led42.SetSize( 11, 11 );
      led42.SetSkin( "Red" );

      led23 = new VoltageLED( "led23", "LED 2.3", this );
      AddComponent( led23 );
      led23.SetWantsMouseNotifications( false );
      led23.SetPosition( 102, 232 );
      led23.SetSize( 11, 11 );
      led23.SetSkin( "Red" );

      led44 = new VoltageLED( "led44", "LED 4.4", this );
      AddComponent( led44 );
      led44.SetWantsMouseNotifications( false );
      led44.SetPosition( 174, 232 );
      led44.SetSize( 11, 11 );
      led44.SetSkin( "Red" );

      led31 = new VoltageLED( "led31", "LED 3.1", this );
      AddComponent( led31 );
      led31.SetWantsMouseNotifications( false );
      led31.SetPosition( 138, 52 );
      led31.SetSize( 11, 11 );
      led31.SetSkin( "Red" );

      led41 = new VoltageLED( "led41", "LED 4.1", this );
      AddComponent( led41 );
      led41.SetWantsMouseNotifications( false );
      led41.SetPosition( 175, 16 );
      led41.SetSize( 11, 11 );
      led41.SetSkin( "Red" );

      led34 = new VoltageLED( "led34", "LED 3.4", this );
      AddComponent( led34 );
      led34.SetWantsMouseNotifications( false );
      led34.SetPosition( 138, 268 );
      led34.SetSize( 11, 11 );
      led34.SetSkin( "Red" );

      led45 = new VoltageLED( "led45", "LED 4.5", this );
      AddComponent( led45 );
      led45.SetWantsMouseNotifications( false );
      led45.SetPosition( 174, 304 );
      led45.SetSize( 11, 11 );
      led45.SetSkin( "Red" );

      led01 = new VoltageLED( "led01", "LED 0.1", this );
      AddComponent( led01 );
      led01.SetWantsMouseNotifications( false );
      led01.SetPosition( 30, 160 );
      led01.SetSize( 11, 11 );
      led01.SetSkin( "Red" );

      triggerIn = new VoltageAudioJack( "triggerIn", "Trigger In", this, JackType.JackType_AudioInput );
      AddComponent( triggerIn );
      triggerIn.SetWantsMouseNotifications( false );
      triggerIn.SetPosition( 8, 24 );
      triggerIn.SetSize( 25, 25 );
      triggerIn.SetSkin( "Jack Round 25px" );

      gateJitterKnob = new VoltageKnob( "gateJitterKnob", "Gate Jitter", this, 0.0, 1.0, 0 );
      AddComponent( gateJitterKnob );
      gateJitterKnob.SetWantsMouseNotifications( false );
      gateJitterKnob.SetPosition( 8, 315 );
      gateJitterKnob.SetSize( 27, 27 );
      gateJitterKnob.SetSkin( "Plastic Orange" );
      gateJitterKnob.SetRange( 0.0, 1.0, 0, false, 0 );
      gateJitterKnob.SetKnobParams( 215, 145 );
      gateJitterKnob.DisplayValueInPercent( true );
      gateJitterKnob.SetKnobAdjustsRing( true );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "LEN" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 74, 277 );
      textLabel13.SetSize( 20, 15 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 1 );
      textLabel13.SetMultiLineEdit( false );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 10, true, false );
}



   //-------------------------------------------------------------------------------
   //  public void Initialize()

      //  Initialize will get called shortly after your module's constructor runs. You can use it to
      //  do any initialization that the auto-generated code doesn't handle.
   //-------------------------------------------------------------------------------
   @Override
   public void Initialize()
   {
      //[user-Initialize]   Add your own initialization code here
      TriggerInput input = new TriggerInput(triggerIn::GetValue);
      eventBus.registerBooleanObserver(triggerIn, input::setIsConnected);
      
      drawLine(gateOut01, gateOut11);
      drawLine(gateOut01, gateOut12);
      drawLine(gateOut11, gateOut21);
      drawLine(gateOut11, gateOut22);
      drawLine(gateOut12, gateOut22);
      drawLine(gateOut12, gateOut23);
      drawLine(gateOut21, gateOut31);
      drawLine(gateOut21, gateOut32);
      drawLine(gateOut22, gateOut32);
      drawLine(gateOut22, gateOut33);
      drawLine(gateOut23, gateOut33);
      drawLine(gateOut23, gateOut34);
      drawLine(gateOut31, gateOut41);
      drawLine(gateOut31, gateOut42);
      drawLine(gateOut32, gateOut42);
      drawLine(gateOut32, gateOut43);
      drawLine(gateOut33, gateOut43);
      drawLine(gateOut33, gateOut44);
      drawLine(gateOut34, gateOut44);
      drawLine(gateOut34, gateOut45);
      
      controller = new Controller(input, model, new DoubleConsumer[] {
         gateOut01::SetValue,
         gateOut11::SetValue,
         gateOut12::SetValue,
         gateOut21::SetValue,
         gateOut22::SetValue,
         gateOut23::SetValue,
         gateOut31::SetValue,
         gateOut32::SetValue,
         gateOut33::SetValue,
         gateOut34::SetValue,
         gateOut41::SetValue,
         gateOut42::SetValue,
         gateOut43::SetValue,
         gateOut44::SetValue,
         gateOut45::SetValue
      });
         
      connector.connect(gateLengthKnob, delayLengthKnob, gateJitterKnob, delayJitterKnob, new Object[] {
         distribution11,
         distribution21, distribution22,
         distribution31, distribution32, distribution33,
         distribution41, distribution42, distribution43, distribution44
      });
      
      leds = new VoltageLED[] {
         led01,
         led11, led12,
         led21, led22, led23,
         led31, led32, led33, led34,
         led41, led42, led43, led44, led45
      };

      StartGuiUpdateTimer();
      //[/user-Initialize]
   }


   //-------------------------------------------------------------------------------
   //  public void Destroy()

      //  Destroy will get called just before your module gets deleted. You can use it to perform any
      //  cleanup that's not handled automatically by Java.
   //-------------------------------------------------------------------------------
   @Override
   public void Destroy()
   {
      super.Destroy();
      //[user-Destroy]   Add your own module-getting-deleted code here



      //[/user-Destroy]
   }


   //-------------------------------------------------------------------------------
   //  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

      //  Notify will get called when various events occur - control values changing, timers firing, etc.
   //-------------------------------------------------------------------------------
   @Override
   public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
   {
      //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
      switch( notification )
      {
         case Knob_Changed: return eventHandler.onKnobValueChanged(component, doubleValue);
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
         }
         break;
      
         case Switch_Changed:   // doubleValue is the new switch value
         {
         }
         break;
      
         case Jack_Connected: return eventHandler.onJackConnected(component);
      
         case Jack_Disconnected: return eventHandler.onJackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
            for (int i=0; i<15; i++) {
               VoltageLED led = leds[i];
               led.SetValue(controller.isGating(i) ? 1.0 : 0.0);
            }
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         // Less common notifications:
      
         case Named_Timer:   // object contains a String with the name of the timer that has fired
         {
         }
         break;
      
         case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
         {
         }
         break;
      
         case Canvas_Painted:   // Canvas painting is complete
         {
         }
         break;
      
         case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
         {
         }
         break;
      
         case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
         {
         }
         break;
      
         case Label_Changed:        // The text of an editable text control has changed
         {
         }
         break;
      
         case SoundPlayback_Start:   // A sound has begun playback
         {
         }
         break;
      
         case SoundPlayback_End:     // A sound has ended playback
         {
         }
         break;
      
         case Scrollbar_Position:    // longValue is the new scrollbar position
         {
         }
         break;
      
         case PolyVoices_Changed:    // longValue is the new number of poly voices
         {
         }
         break;
      
         case File_Dropped:     // 'object' is a String containing the file path
         {
         }
         break;
      
         case Preset_Loading_Start:   // called when preset loading begins
         {
         }
         break;
      
         case Preset_Loading_Finish:  // called when preset loading finishes
         {
         }
         break;
      
         case Variation_Loading_Start:    // sent when a variation is about to load
         {
         }
         break;
      
         case Variation_Loading_Finish:   // sent when a variation has just finished loading
         {
         }
         break;
      
         case Tempo_Changed:     // doubleValue is the new tempo
         {
         }
         break;
      
         case Randomized:     // called when the module's controls get randomized
         {
         }
         break;
      
         case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
         {
         }
         break;
      
         case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
         {
         }
         break;
      
         case Reset:    // sent when the module has been reset to default settings
         {
         }
         break;
      
         case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
         {
         }
         break;
      }



      return false;
      //[/user-Notify]
   }


   //-------------------------------------------------------------------------------
   //  public void ProcessSample()

      //  ProcessSample is called once per sample. Usually it's where you read
      //  from input jacks, process audio, and write it to your output jacks.
      //  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
      //  to other threads when possible and avoid calling native functions.
   //-------------------------------------------------------------------------------
   @Override
   public void ProcessSample()
   {
      //[user-ProcessSample]   Add your own process-sampling code here
      controller.processSample();


      //[/user-ProcessSample]
   }


   //-------------------------------------------------------------------------------
   //  public String GetTooltipText( VoltageComponent component )

      //  Gets called when a tooltip is about to display for a control. Override it if
      //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
      //  for instance, you can translate the knob's current value to a log-based string and display it here.
   //-------------------------------------------------------------------------------
   @Override
   public String GetTooltipText( VoltageComponent component )
   {
      //[user-GetTooltipText]   Add your own code here
      if (component.GetDisplayName().startsWith("Distribution")) {
         if (component.GetValue() == 0.0) return "Always low";
         if (component.GetValue() == 1.0) return "Always high";
         var pchigh = (int) (component.GetValue() * 100.0);
         var pclow = 100 - pchigh;
         return pclow + "% low, " + pchigh + "% high";
      }

      return super.GetTooltipText( component );
      //[/user-GetTooltipText]
   }


   //-------------------------------------------------------------------------------
   //  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

      //  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
      //  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
      //  in GetTooltipText().
   //-------------------------------------------------------------------------------
   @Override
   public void EditComponentValue( VoltageComponent component, double newValue, String newText )
   {
      //[user-EditComponentValue]   Add your own code here



      //[/user-EditComponentValue]
      super.EditComponentValue( component, newValue, newText );
   }


   //-------------------------------------------------------------------------------
   //  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

      //  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
      //  process them in this function when they get triggered by undo/redo actions.
   //-------------------------------------------------------------------------------
   @Override
   public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
   {
      //[user-OnUndoRedo]   Add your own code here



      //[/user-OnUndoRedo]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformation()

      //  Gets called when the module's state gets saved, typically when the user saves a preset with
      //  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformation()
   {
      //[user-GetStateInformation]   Add your own code here



      return null;
      //[/user-GetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformation(byte[] stateInfo)

      //  Gets called when this module's state is getting restored, typically when a user opens a preset with
      //  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformation(byte[] stateInfo)
   {
      //[user-SetStateInformation]   Add your own code here



      //[/user-SetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformationForVariations()

      //  Gets called when a user saves a variation with this module in it.
      //  Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformationForVariations()
   {
      //[user-GetStateInformationForVariations]   Add your own code here



      return GetStateInformation();
      //[/user-GetStateInformationForVariations]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformationForVariations(byte[] stateInfo)

      //  Gets called when a user loads a variation with this module in it.
      //  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformationForVariations(byte[] stateInfo)
   {
      //[user-SetStateInformationForVariations]   Add your own code here
      SetStateInformation(stateInfo);



      //[/user-SetStateInformationForVariations]
   }


   // Auto-generated variables
   private VoltageLabel textLabel13;
   private VoltageKnob gateJitterKnob;
   private VoltageAudioJack triggerIn;
   private VoltageLED led01;
   private VoltageLED led45;
   private VoltageLED led34;
   private VoltageLED led41;
   private VoltageLED led31;
   private VoltageLED led44;
   private VoltageLED led23;
   private VoltageLED led42;
   private VoltageLED led21;
   private VoltageLED led22;
   private VoltageLED led43;
   private VoltageLED led33;
   private VoltageLED led32;
   private VoltageLED led12;
   private VoltageLED led11;
   private VoltageKnob distribution44;
   private VoltageAudioJack gateOut45;
   private VoltageKnob distribution43;
   private VoltageKnob distribution41;
   private VoltageKnob distribution42;
   private VoltageAudioJack gateOut44;
   private VoltageAudioJack gateOut43;
   private VoltageAudioJack gateOut41;
   private VoltageAudioJack gateOut42;
   private VoltageKnob distribution33;
   private VoltageAudioJack gateOut34;
   private VoltageKnob distribution32;
   private VoltageKnob distribution31;
   private VoltageAudioJack gateOut33;
   private VoltageAudioJack gateOut31;
   private VoltageAudioJack gateOut32;
   private VoltageKnob distribution22;
   private VoltageAudioJack gateOut23;
   private VoltageKnob delayJitterKnob;
   private VoltageKnob distribution11;
   private VoltageKnob delayLengthKnob;
   private VoltageKnob gateLengthKnob;
   private VoltageAudioJack gateOut21;
   private VoltageAudioJack gateOut11;
   private VoltageKnob distribution21;
   private VoltageAudioJack gateOut12;
   private VoltageAudioJack gateOut22;
   private VoltageAudioJack gateOut01;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;


   //[user-code-and-variables]    Add your own variables and functions here
private final EventBus eventBus = new EventBus();
private final UIEventHandler eventHandler = new UIEventHandler(eventBus);
private final Model model = new Model();
private final Connector connector = new Connector(model, eventBus);
private Controller controller;
private VoltageLED[] leds;
private int lineId;

private void drawLine(VoltageAudioJack source, VoltageAudioJack target) {
      VoltageLine line0 = new VoltageLine( "line" + lineId, "line" + lineId, this );
      AddComponent( line0 );
      line0.SetWantsMouseNotifications( false );
      line0.SetLineColor( new Color( 255, 255, 20, 32 ) );
      line0.SetLineWidth( (float)2 );
      line0.SetStartPosition( source.GetX() + 12, source.GetY() + 12 );
      line0.SetEndPosition( target.GetX() + 12, target.GetY() + 12 );
      line0.SetZOrder(0);
}
   //[/user-code-and-variables]
}

 
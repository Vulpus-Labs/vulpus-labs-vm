package com.vulpuslabs.catkins;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.catkins.*;
import com.vulpuslabs.vulpes.values.inputs.CvModulatableKnob;
import com.vulpuslabs.vulpes.values.events.NotificationReceiver;


//[/user-imports]


public class Catkins extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Catkins( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Catkins", ModuleType.ModuleType_Effect, 2.0 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "da592586ce7e43d7bdffc1df86ff7e40" );
   }

void InitializeControls()
{

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "MIX" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 73, 18 );
      textLabel4.SetSize( 33, 28 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 2 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "FBCK" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 38, 18 );
      textLabel3.SetSize( 33, 28 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 2 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "OUT" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 107, 18 );
      textLabel2.SetSize( 33, 28 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 2 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "IN" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 4, 18 );
      textLabel1.SetSize( 33, 28 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 2 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "Arial", 10, true, false );

      inputJack = new VoltageAudioJack( "inputJack", "Input", this, JackType.JackType_AudioInput );
      AddComponent( inputJack );
      inputJack.SetWantsMouseNotifications( false );
      inputJack.SetPosition( 8, 32 );
      inputJack.SetSize( 25, 25 );
      inputJack.SetSkin( "Mini Jack 25px" );

      outputJack = new VoltageAudioJack( "outputJack", "Output", this, JackType.JackType_AudioOutput );
      AddComponent( outputJack );
      outputJack.SetWantsMouseNotifications( false );
      outputJack.SetPosition( 111, 32 );
      outputJack.SetSize( 25, 25 );
      outputJack.SetSkin( "Mini Jack 25px" );

      feedbackKnob = new VoltageKnob( "feedbackKnob", "Feedback", this, 0.0, 1.0, 0.0 );
      AddComponent( feedbackKnob );
      feedbackKnob.SetWantsMouseNotifications( false );
      feedbackKnob.SetPosition( 41, 32 );
      feedbackKnob.SetSize( 27, 27 );
      feedbackKnob.SetSkin( "Plastic Mint" );
      feedbackKnob.SetRange( 0.0, 1.0, 0.0, false, 0 );
      feedbackKnob.SetKnobParams( 215, 145 );
      feedbackKnob.DisplayValueInPercent( true );
      feedbackKnob.SetKnobAdjustsRing( true );

      mixKnob = new VoltageKnob( "mixKnob", "Wet/Dry Mix", this, 0.0, 1.0, 0.5 );
      AddComponent( mixKnob );
      mixKnob.SetWantsMouseNotifications( false );
      mixKnob.SetPosition( 76, 32 );
      mixKnob.SetSize( 27, 27 );
      mixKnob.SetSkin( "Plastic Orange" );
      mixKnob.SetRange( 0.0, 1.0, 0.5, false, 0 );
      mixKnob.SetKnobParams( 215, 145 );
      mixKnob.DisplayValueInPercent( false );
      mixKnob.SetKnobAdjustsRing( true );

      feedbackModCv = new VoltageAudioJack( "feedbackModCv", "Feedback Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( feedbackModCv );
      feedbackModCv.SetWantsMouseNotifications( false );
      feedbackModCv.SetPosition( 17, 62 );
      feedbackModCv.SetSize( 25, 25 );
      feedbackModCv.SetSkin( "Mini Jack 25px" );

      mixModCv = new VoltageAudioJack( "mixModCv", "Mix Mod CV", this, JackType.JackType_AudioInput );
      AddComponent( mixModCv );
      mixModCv.SetWantsMouseNotifications( false );
      mixModCv.SetPosition( 102, 62 );
      mixModCv.SetSize( 25, 25 );
      mixModCv.SetSkin( "Mini Jack 25px" );

      feedbackModAmount = new VoltageKnob( "feedbackModAmount", "Feedback Mod Amount", this, 0.0, 1.0, 0.5 );
      AddComponent( feedbackModAmount );
      feedbackModAmount.SetWantsMouseNotifications( false );
      feedbackModAmount.SetPosition( 48, 67 );
      feedbackModAmount.SetSize( 15, 15 );
      feedbackModAmount.SetSkin( "ARP2500 Sm Silver" );
      feedbackModAmount.SetRange( 0.0, 1.0, 0.5, false, 0 );
      feedbackModAmount.SetKnobParams( 215, 145 );
      feedbackModAmount.DisplayValueInPercent( false );
      feedbackModAmount.SetKnobAdjustsRing( true );

      mixModAmount = new VoltageKnob( "mixModAmount", "Mix Mod Amount", this, 0.0, 1.0, 0.5 );
      AddComponent( mixModAmount );
      mixModAmount.SetWantsMouseNotifications( false );
      mixModAmount.SetPosition( 82, 67 );
      mixModAmount.SetSize( 15, 15 );
      mixModAmount.SetSkin( "ARP2500 Sm Silver" );
      mixModAmount.SetRange( 0.0, 1.0, 0.5, false, 0 );
      mixModAmount.SetKnobParams( 215, 145 );
      mixModAmount.DisplayValueInPercent( false );
      mixModAmount.SetKnobAdjustsRing( true );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "CATKINS" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 0, 0 );
      textLabel5.SetSize( 144, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 0, 0, 0, 0 ) );
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

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "VULPUS LABS" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 0, 345 );
      textLabel6.SetSize( 144, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 0, 0, 0, 0 ) );
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

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "POS" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 4, 93 );
      textLabel7.SetSize( 33, 14 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 2 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 10, true, false );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "10ms" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 58, 311 );
      textLabel13.SetSize( 20, 14 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 2 );
      textLabel13.SetMultiLineEdit( false );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 10, true, false );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "10s" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 120, 311 );
      textLabel14.SetSize( 20, 14 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel14.SetBorderSize( 2 );
      textLabel14.SetMultiLineEdit( false );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "Arial", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "RANGE" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 4, 311 );
      textLabel15.SetSize( 50, 14 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel15.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 2 );
      textLabel15.SetMultiLineEdit( false );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "Arial", 10, true, false );

      textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "QUALITY" );
      AddComponent( textLabel16 );
      textLabel16.SetWantsMouseNotifications( false );
      textLabel16.SetPosition( 4, 328 );
      textLabel16.SetSize( 50, 14 );
      textLabel16.SetEditable( false, false );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel16.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel16.SetBorderSize( 2 );
      textLabel16.SetMultiLineEdit( false );
      textLabel16.SetIsNumberEditor( false );
      textLabel16.SetNumberEditorRange( 0, 100 );
      textLabel16.SetNumberEditorInterval( 1 );
      textLabel16.SetNumberEditorUsesMouseWheel( false );
      textLabel16.SetHasCustomTextHoverColor( false );
      textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetFont( "Arial", 10, true, false );

      textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "LOW" );
      AddComponent( textLabel17 );
      textLabel17.SetWantsMouseNotifications( false );
      textLabel17.SetPosition( 58, 328 );
      textLabel17.SetSize( 20, 14 );
      textLabel17.SetEditable( false, false );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel17.SetBorderSize( 2 );
      textLabel17.SetMultiLineEdit( false );
      textLabel17.SetIsNumberEditor( false );
      textLabel17.SetNumberEditorRange( 0, 100 );
      textLabel17.SetNumberEditorInterval( 1 );
      textLabel17.SetNumberEditorUsesMouseWheel( false );
      textLabel17.SetHasCustomTextHoverColor( false );
      textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetFont( "Arial", 10, true, false );

      textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "HIGH" );
      AddComponent( textLabel18 );
      textLabel18.SetWantsMouseNotifications( false );
      textLabel18.SetPosition( 119, 328 );
      textLabel18.SetSize( 20, 14 );
      textLabel18.SetEditable( false, false );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel18.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel18.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel18.SetBorderSize( 2 );
      textLabel18.SetMultiLineEdit( false );
      textLabel18.SetIsNumberEditor( false );
      textLabel18.SetNumberEditorRange( 0, 100 );
      textLabel18.SetNumberEditorInterval( 1 );
      textLabel18.SetNumberEditorUsesMouseWheel( false );
      textLabel18.SetHasCustomTextHoverColor( false );
      textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetFont( "Arial", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "MOD" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 38, 93 );
      textLabel8.SetSize( 33, 14 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel8.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 2 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 10, true, false );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "SEND" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 73, 93 );
      textLabel9.SetSize( 33, 14 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 2 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "RET" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 107, 93 );
      textLabel10.SetSize( 33, 14 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.Top );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 2 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      qualitySwitch = new VoltageSwitch( "qualitySwitch", "Quality", this, 0 );
      AddComponent( qualitySwitch );
      qualitySwitch.SetWantsMouseNotifications( false );
      qualitySwitch.SetPosition( 81, 328 );
      qualitySwitch.SetSize( 37, 15 );
      qualitySwitch.SetSkin( "Rocker Switch Plastic Orange Hor" );

      head1PositionMod = new VoltageAudioJack( "head1PositionMod", "Head 1 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head1PositionMod );
      head1PositionMod.SetWantsMouseNotifications( false );
      head1PositionMod.SetPosition( 41, 112 );
      head1PositionMod.SetSize( 25, 25 );
      head1PositionMod.SetSkin( "Mini Jack 25px" );

      head4PositionMod = new VoltageAudioJack( "head4PositionMod", "Head 4 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head4PositionMod );
      head4PositionMod.SetWantsMouseNotifications( false );
      head4PositionMod.SetPosition( 41, 212 );
      head4PositionMod.SetSize( 25, 25 );
      head4PositionMod.SetSkin( "Mini Jack 25px" );

      head1Position = new VoltageKnob( "head1Position", "Head 1 Position", this, 0.0, 1, 0.50 );
      AddComponent( head1Position );
      head1Position.SetWantsMouseNotifications( false );
      head1Position.SetPosition( 8, 112 );
      head1Position.SetSize( 27, 27 );
      head1Position.SetSkin( "Plastic Blue" );
      head1Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head1Position.SetKnobParams( 215, 145 );
      head1Position.SetUnits( "s" );
      head1Position.DisplayValueInPercent( false );
      head1Position.SetKnobAdjustsRing( true );

      head4Position = new VoltageKnob( "head4Position", "Head 4 Position", this, 0.0, 1, 0.50 );
      AddComponent( head4Position );
      head4Position.SetWantsMouseNotifications( false );
      head4Position.SetPosition( 8, 212 );
      head4Position.SetSize( 27, 27 );
      head4Position.SetSkin( "Plastic Blue" );
      head4Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head4Position.SetKnobParams( 215, 145 );
      head4Position.SetUnits( "s" );
      head4Position.DisplayValueInPercent( false );
      head4Position.SetKnobAdjustsRing( true );

      head1Send = new VoltageAudioJack( "head1Send", "Head 1 Send", this, JackType.JackType_AudioOutput );
      AddComponent( head1Send );
      head1Send.SetWantsMouseNotifications( false );
      head1Send.SetPosition( 76, 112 );
      head1Send.SetSize( 25, 25 );
      head1Send.SetSkin( "Mini Jack 25px" );

      head4Send = new VoltageAudioJack( "head4Send", "Head 4 Send", this, JackType.JackType_AudioOutput );
      AddComponent( head4Send );
      head4Send.SetWantsMouseNotifications( false );
      head4Send.SetPosition( 76, 212 );
      head4Send.SetSize( 25, 25 );
      head4Send.SetSkin( "Mini Jack 25px" );

      head1Return = new VoltageAudioJack( "head1Return", "Head 1 Return", this, JackType.JackType_AudioInput );
      AddComponent( head1Return );
      head1Return.SetWantsMouseNotifications( false );
      head1Return.SetPosition( 111, 112 );
      head1Return.SetSize( 25, 25 );
      head1Return.SetSkin( "Mini Jack 25px" );

      head4Return = new VoltageAudioJack( "head4Return", "Head 4 Return", this, JackType.JackType_AudioInput );
      AddComponent( head4Return );
      head4Return.SetWantsMouseNotifications( false );
      head4Return.SetPosition( 111, 212 );
      head4Return.SetSize( 25, 25 );
      head4Return.SetSkin( "Mini Jack 25px" );

      head2PositionMod = new VoltageAudioJack( "head2PositionMod", "Head 2 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head2PositionMod );
      head2PositionMod.SetWantsMouseNotifications( false );
      head2PositionMod.SetPosition( 41, 145 );
      head2PositionMod.SetSize( 25, 25 );
      head2PositionMod.SetSkin( "Mini Jack 25px" );

      head5PositionMod = new VoltageAudioJack( "head5PositionMod", "Head 5 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head5PositionMod );
      head5PositionMod.SetWantsMouseNotifications( false );
      head5PositionMod.SetPosition( 41, 244 );
      head5PositionMod.SetSize( 25, 25 );
      head5PositionMod.SetSkin( "Mini Jack 25px" );

      head2Position = new VoltageKnob( "head2Position", "Head 2 Position", this, 0.0, 1, 0.50 );
      AddComponent( head2Position );
      head2Position.SetWantsMouseNotifications( false );
      head2Position.SetPosition( 8, 145 );
      head2Position.SetSize( 27, 27 );
      head2Position.SetSkin( "Plastic Blue" );
      head2Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head2Position.SetKnobParams( 215, 145 );
      head2Position.SetUnits( "s" );
      head2Position.DisplayValueInPercent( false );
      head2Position.SetKnobAdjustsRing( true );

      head5Position = new VoltageKnob( "head5Position", "Head 5 Position", this, 0.0, 1, 0.50 );
      AddComponent( head5Position );
      head5Position.SetWantsMouseNotifications( false );
      head5Position.SetPosition( 8, 244 );
      head5Position.SetSize( 27, 27 );
      head5Position.SetSkin( "Plastic Blue" );
      head5Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head5Position.SetKnobParams( 215, 145 );
      head5Position.SetUnits( "s" );
      head5Position.DisplayValueInPercent( false );
      head5Position.SetKnobAdjustsRing( true );

      head2Send = new VoltageAudioJack( "head2Send", "Head 2 Send", this, JackType.JackType_AudioOutput );
      AddComponent( head2Send );
      head2Send.SetWantsMouseNotifications( false );
      head2Send.SetPosition( 76, 145 );
      head2Send.SetSize( 25, 25 );
      head2Send.SetSkin( "Mini Jack 25px" );

      head5Send = new VoltageAudioJack( "head5Send", "Head 5 Send", this, JackType.JackType_AudioOutput );
      AddComponent( head5Send );
      head5Send.SetWantsMouseNotifications( false );
      head5Send.SetPosition( 76, 244 );
      head5Send.SetSize( 25, 25 );
      head5Send.SetSkin( "Mini Jack 25px" );

      head2Return = new VoltageAudioJack( "head2Return", "Head 2 Return", this, JackType.JackType_AudioInput );
      AddComponent( head2Return );
      head2Return.SetWantsMouseNotifications( false );
      head2Return.SetPosition( 111, 145 );
      head2Return.SetSize( 25, 25 );
      head2Return.SetSkin( "Mini Jack 25px" );

      head5Return = new VoltageAudioJack( "head5Return", "Head 5 Return", this, JackType.JackType_AudioInput );
      AddComponent( head5Return );
      head5Return.SetWantsMouseNotifications( false );
      head5Return.SetPosition( 111, 244 );
      head5Return.SetSize( 25, 25 );
      head5Return.SetSkin( "Mini Jack 25px" );

      head6PositionMod = new VoltageAudioJack( "head6PositionMod", "Head 6 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head6PositionMod );
      head6PositionMod.SetWantsMouseNotifications( false );
      head6PositionMod.SetPosition( 41, 277 );
      head6PositionMod.SetSize( 25, 25 );
      head6PositionMod.SetSkin( "Mini Jack 25px" );

      head3PositionMod = new VoltageAudioJack( "head3PositionMod", "Head 3 Position Mod", this, JackType.JackType_AudioInput );
      AddComponent( head3PositionMod );
      head3PositionMod.SetWantsMouseNotifications( false );
      head3PositionMod.SetPosition( 41, 178 );
      head3PositionMod.SetSize( 25, 25 );
      head3PositionMod.SetSkin( "Mini Jack 25px" );

      head3Position = new VoltageKnob( "head3Position", "Head 3 Position", this, 0.0, 1, 0.50 );
      AddComponent( head3Position );
      head3Position.SetWantsMouseNotifications( false );
      head3Position.SetPosition( 8, 178 );
      head3Position.SetSize( 27, 27 );
      head3Position.SetSkin( "Plastic Blue" );
      head3Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head3Position.SetKnobParams( 215, 145 );
      head3Position.SetUnits( "s" );
      head3Position.DisplayValueInPercent( false );
      head3Position.SetKnobAdjustsRing( true );

      head6Position = new VoltageKnob( "head6Position", "Head 6 Position", this, 0.0, 1, 0.50 );
      AddComponent( head6Position );
      head6Position.SetWantsMouseNotifications( false );
      head6Position.SetPosition( 8, 277 );
      head6Position.SetSize( 27, 27 );
      head6Position.SetSkin( "Plastic Blue" );
      head6Position.SetRange( 0.0, 1, 0.50, false, 0 );
      head6Position.SetKnobParams( 215, 145 );
      head6Position.SetUnits( "s" );
      head6Position.DisplayValueInPercent( false );
      head6Position.SetKnobAdjustsRing( true );

      head6Send = new VoltageAudioJack( "head6Send", "Head 6 Send", this, JackType.JackType_AudioOutput );
      AddComponent( head6Send );
      head6Send.SetWantsMouseNotifications( false );
      head6Send.SetPosition( 76, 277 );
      head6Send.SetSize( 25, 25 );
      head6Send.SetSkin( "Mini Jack 25px" );

      head3Send = new VoltageAudioJack( "head3Send", "Head 3 Send", this, JackType.JackType_AudioOutput );
      AddComponent( head3Send );
      head3Send.SetWantsMouseNotifications( false );
      head3Send.SetPosition( 76, 178 );
      head3Send.SetSize( 25, 25 );
      head3Send.SetSkin( "Mini Jack 25px" );

      head3Return = new VoltageAudioJack( "head3Return", "Head 3 Return", this, JackType.JackType_AudioInput );
      AddComponent( head3Return );
      head3Return.SetWantsMouseNotifications( false );
      head3Return.SetPosition( 111, 178 );
      head3Return.SetSize( 25, 25 );
      head3Return.SetSkin( "Mini Jack 25px" );

      head6Return = new VoltageAudioJack( "head6Return", "Head 6 Return", this, JackType.JackType_AudioInput );
      AddComponent( head6Return );
      head6Return.SetWantsMouseNotifications( false );
      head6Return.SetPosition( 111, 277 );
      head6Return.SetSize( 25, 25 );
      head6Return.SetSkin( "Mini Jack 25px" );

      rangeSwitch = new VoltageSwitch( "rangeSwitch", "Range", this, 0 );
      AddComponent( rangeSwitch );
      rangeSwitch.SetWantsMouseNotifications( false );
      rangeSwitch.SetPosition( 80, 311 );
      rangeSwitch.SetSize( 37, 15 );
      rangeSwitch.SetSkin( "5-State Slide Horizontal" );
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
      controller = new Controller(
         inputJack::GetValue,
         new CvModulatableKnob(
            feedbackKnob.GetMinValue(),
            feedbackKnob.GetMaxValue(),
            receiver.registerInput(feedbackModCv, feedbackModCv::GetValue),
            receiver.registerSmoothedKnob(feedbackKnob, feedbackKnob.GetValue()),
            receiver.registerSmoothedKnob(feedbackModAmount, feedbackModAmount.GetValue())),
         new CvModulatableKnob(
            mixKnob.GetMinValue(),
            mixKnob.GetMaxValue(),
            receiver.registerInput(mixModCv, mixModCv::GetValue),
            receiver.registerSmoothedKnob(mixKnob, mixKnob.GetValue()),
            receiver.registerSmoothedKnob(mixModAmount, mixModAmount.GetValue())),         
         outputJack::SetValue,
         new ReadHead[] {
            new ReadHead(
               receiver.registerSmoothedKnob(head1Position, head1Position.GetValue()),
               receiver.registerInput(head1PositionMod, head1PositionMod::GetValue),
               receiver.registerOutput(head1Send, head1Send::SetValue),
               receiver.registerInput(head1Return, head1Return::GetValue)),
            new ReadHead(
               receiver.registerSmoothedKnob(head2Position, head2Position.GetValue()),
               receiver.registerInput(head2PositionMod, head2PositionMod::GetValue),
               receiver.registerOutput(head2Send, head2Send::SetValue),
               receiver.registerInput(head2Return, head2Return::GetValue)),
            new ReadHead(
               receiver.registerSmoothedKnob(head3Position, head3Position.GetValue()),
               receiver.registerInput(head3PositionMod, head3PositionMod::GetValue),
               receiver.registerOutput(head3Send, head3Send::SetValue),
               receiver.registerInput(head3Return, head3Return::GetValue)),
            new ReadHead(
               receiver.registerSmoothedKnob(head4Position, head4Position.GetValue()),
               receiver.registerInput(head4PositionMod, head4PositionMod::GetValue),
               receiver.registerOutput(head4Send, head4Send::SetValue),
               receiver.registerInput(head4Return, head4Return::GetValue)),
            new ReadHead(
               receiver.registerSmoothedKnob(head5Position, head5Position.GetValue()),
               receiver.registerInput(head5PositionMod, head5PositionMod::GetValue),
               receiver.registerOutput(head5Send, head5Send::SetValue),
               receiver.registerInput(head5Return, head5Return::GetValue)),
            new ReadHead(
               receiver.registerSmoothedKnob(head6Position, head6Position.GetValue()),
               receiver.registerInput(head6PositionMod, head6PositionMod::GetValue),
               receiver.registerOutput(head6Send, head6Send::SetValue),
               receiver.registerInput(head6Return, head6Return::GetValue))
         }
      );
      
      receiver.registerTwoStateSwitch(qualitySwitch, controller::setInterpolationQuality);
      receiver.register(rangeSwitch, controller::setRange);


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
         case Knob_Changed: return receiver.knobValueChanged(component, doubleValue);
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
         }
         break;
      
         case Switch_Changed: return receiver.switchChanged(component, doubleValue);
      
         case Jack_Connected: return receiver.jackConnected(component);
      
         case Jack_Disconnected: return receiver.jackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
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
      if (component == head1Position
         || component == head2Position
         || component == head3Position
         || component == head4Position
         || component == head5Position) {
            VoltageKnob knob = (VoltageKnob) component;
            return controller.getPosDescription(knob.GetValue(), rangeSwitch.GetValue());
      }
      
      if (component == rangeSwitch) {
         return controller.getRangeDescription(rangeSwitch.GetValue());
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
   private VoltageSwitch rangeSwitch;
   private VoltageAudioJack head6Return;
   private VoltageAudioJack head3Return;
   private VoltageAudioJack head3Send;
   private VoltageAudioJack head6Send;
   private VoltageKnob head6Position;
   private VoltageKnob head3Position;
   private VoltageAudioJack head3PositionMod;
   private VoltageAudioJack head6PositionMod;
   private VoltageAudioJack head5Return;
   private VoltageAudioJack head2Return;
   private VoltageAudioJack head5Send;
   private VoltageAudioJack head2Send;
   private VoltageKnob head5Position;
   private VoltageKnob head2Position;
   private VoltageAudioJack head5PositionMod;
   private VoltageAudioJack head2PositionMod;
   private VoltageAudioJack head4Return;
   private VoltageAudioJack head1Return;
   private VoltageAudioJack head4Send;
   private VoltageAudioJack head1Send;
   private VoltageKnob head4Position;
   private VoltageKnob head1Position;
   private VoltageAudioJack head4PositionMod;
   private VoltageAudioJack head1PositionMod;
   private VoltageSwitch qualitySwitch;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel18;
   private VoltageLabel textLabel17;
   private VoltageLabel textLabel16;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageKnob mixModAmount;
   private VoltageKnob feedbackModAmount;
   private VoltageAudioJack mixModCv;
   private VoltageAudioJack feedbackModCv;
   private VoltageKnob mixKnob;
   private VoltageKnob feedbackKnob;
   private VoltageAudioJack outputJack;
   private VoltageAudioJack inputJack;
   private VoltageLabel textLabel1;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel3;
   private VoltageLabel textLabel4;


   //[user-code-and-variables]    Add your own variables and functions here
private final NotificationReceiver receiver = new NotificationReceiver();
private Controller controller;




   //[/user-code-and-variables]
}

 
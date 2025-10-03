package com.vulpuslabs.rapscallion;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.rapscallion.*;
import com.vulpuslabs.vulpes.values.events.*;


//[/user-imports]


public class Rapscallion extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Rapscallion( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Rapscallion", ModuleType.ModuleType_Effect, 2.2 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "556f4fb631af413585b6c300006482f6" );
   }

void InitializeControls()
{

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "TRIGGER IN" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 7, 74 );
      textLabel1.SetSize( 106, 14 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel1.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 1 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "<Sans-Serif>", 10, true, false );

      triggerIn = new VoltageAudioJack( "triggerIn", "Trigger", this, JackType.JackType_AudioInput );
      AddComponent( triggerIn );
      triggerIn.SetWantsMouseNotifications( false );
      triggerIn.SetPosition( 9, 94 );
      triggerIn.SetSize( 25, 25 );
      triggerIn.SetSkin( "Mini Jack 25px" );

      triggerButton = new VoltageButton( "triggerButton", "Trigger Button", this );
      AddComponent( triggerButton );
      triggerButton.SetWantsMouseNotifications( false );
      triggerButton.SetPosition( 51, 95 );
      triggerButton.SetSize( 22, 22 );
      triggerButton.SetSkin( "2500 Round Red" );
      triggerButton.ShowOverlay( false );
      triggerButton.SetOverlayText( "" );
      triggerButton.SetAutoRepeat( false );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "LENGTH" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 7, 126 );
      textLabel3.SetSize( 106, 15 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "8ve UP" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 115, 178 );
      textLabel4.SetSize( 34, 15 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetBkColor( new Color( 160, 160, 255, 255 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "<Sans-Serif>", 10, true, false );

      octaveUpButton = new VoltageToggle( "octaveUpButton", "Octave Up Button", this, false, 0 );
      AddComponent( octaveUpButton );
      octaveUpButton.SetWantsMouseNotifications( false );
      octaveUpButton.SetPosition( 121, 201 );
      octaveUpButton.SetSize( 21, 21 );
      octaveUpButton.SetSkin( "Mini Blue" );
      octaveUpButton.ShowOverlay( false );
      octaveUpButton.SetOverlayText( "" );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "REV" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 115, 229 );
      textLabel5.SetSize( 34, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetBkColor( new Color( 160, 160, 255, 255 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( false );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "T/OUT" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 115, 74 );
      textLabel8.SetSize( 34, 14 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "<Sans-Serif>", 10, true, false );

      loopInL = new VoltageAudioJack( "loopInL", "Loop In L", this, JackType.JackType_AudioInput );
      AddComponent( loopInL );
      loopInL.SetWantsMouseNotifications( false );
      loopInL.SetPosition( 11, 41 );
      loopInL.SetSize( 25, 25 );
      loopInL.SetSkin( "Mini Jack 25px" );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "RAPSCALLION" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 0, 0 );
      textLabel10.SetSize( 158, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 255, 65, 65, 0 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "VULPUS LABS" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 0, 345 );
      textLabel12.SetSize( 158, 15 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 255, 65, 65, 0 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( false );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "<Sans-Serif>", 10, true, false );

      lengthKnob = new VoltageKnob( "lengthKnob", "Length Knob", this, 0.01, 1.0, 0.5 );
      AddComponent( lengthKnob );
      lengthKnob.SetWantsMouseNotifications( false );
      lengthKnob.SetPosition( 83, 146 );
      lengthKnob.SetSize( 27, 27 );
      lengthKnob.SetSkin( "Plastic Red" );
      lengthKnob.SetRange( 0.01, 1.0, 0.5, false, 0 );
      lengthKnob.SetKnobParams( 215, 145 );
      lengthKnob.DisplayValueInPercent( true );
      lengthKnob.SetKnobAdjustsRing( true );
      lengthKnob.SetMidpointValue( 0.3 );

      reverseButton = new VoltageToggle( "reverseButton", "Reverse Button", this, false, 0 );
      AddComponent( reverseButton );
      reverseButton.SetWantsMouseNotifications( false );
      reverseButton.SetPosition( 121, 252 );
      reverseButton.SetSize( 21, 21 );
      reverseButton.SetSkin( "Mini Blue" );
      reverseButton.ShowOverlay( false );
      reverseButton.SetOverlayText( "" );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "PITCH" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 7, 280 );
      textLabel6.SetSize( 106, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetBkColor( new Color( 160, 160, 255, 255 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "<Sans-Serif>", 10, true, false );

      pitchKnob = new VoltageKnob( "pitchKnob", "Pitch Knob", this, -7, 7, 0 );
      AddComponent( pitchKnob );
      pitchKnob.SetWantsMouseNotifications( false );
      pitchKnob.SetPosition( 83, 300 );
      pitchKnob.SetSize( 27, 27 );
      pitchKnob.SetSkin( "Plastic Dark Blue" );
      pitchKnob.SetRange( -7, 7, 0, false, 0 );
      pitchKnob.SetKnobParams( 215, 145 );
      pitchKnob.SetUnits( "semitones" );
      pitchKnob.DisplayValueInPercent( false );
      pitchKnob.SetKnobAdjustsRing( true );
      pitchKnob.SetRangeSkewValue( 0.4, true );

      loopOutL = new VoltageAudioJack( "loopOutL", "Loop Out L", this, JackType.JackType_AudioOutput );
      AddComponent( loopOutL );
      loopOutL.SetWantsMouseNotifications( false );
      loopOutL.SetPosition( 47, 41 );
      loopOutL.SetSize( 25, 25 );
      loopOutL.SetSkin( "Mini Jack 25px" );

      fadeOutTrigger = new VoltageAudioJack( "fadeOutTrigger", "Fade Out Trigger", this, JackType.JackType_AudioOutput );
      AddComponent( fadeOutTrigger );
      fadeOutTrigger.SetWantsMouseNotifications( false );
      fadeOutTrigger.SetPosition( 119, 94 );
      fadeOutTrigger.SetSize( 25, 25 );
      fadeOutTrigger.SetSkin( "Mini Jack 25px" );

      loopOutR = new VoltageAudioJack( "loopOutR", "Loop Out R", this, JackType.JackType_AudioOutput );
      AddComponent( loopOutR );
      loopOutR.SetWantsMouseNotifications( false );
      loopOutR.SetPosition( 119, 41 );
      loopOutR.SetSize( 25, 25 );
      loopOutR.SetSkin( "Mini Jack 25px" );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "M/OUT" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 115, 280 );
      textLabel7.SetSize( 34, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetBkColor( new Color( 160, 160, 255, 255 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "<Sans-Serif>", 10, true, false );

      modOut = new VoltageAudioJack( "modOut", "Mod Output", this, JackType.JackType_AudioOutput );
      AddComponent( modOut );
      modOut.SetWantsMouseNotifications( false );
      modOut.SetPosition( 119, 301 );
      modOut.SetSize( 25, 25 );
      modOut.SetSkin( "Mini Jack 25px" );

      activeIndicator = new VoltageLED( "activeIndicator", "Active Indicator", this );
      AddComponent( activeIndicator );
      activeIndicator.SetWantsMouseNotifications( false );
      activeIndicator.SetPosition( 88, 99 );
      activeIndicator.SetSize( 15, 15 );
      activeIndicator.SetSkin( "2500 Lamp Red" );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "FADE" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 7, 178 );
      textLabel9.SetSize( 106, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "<Sans-Serif>", 10, true, false );

      fadeKnob = new VoltageKnob( "fadeKnob", "Fade Knob", this, 0.01, 1.0, 0.5 );
      AddComponent( fadeKnob );
      fadeKnob.SetWantsMouseNotifications( false );
      fadeKnob.SetPosition( 83, 198 );
      fadeKnob.SetSize( 27, 27 );
      fadeKnob.SetSkin( "Plastic Red" );
      fadeKnob.SetRange( 0.01, 1.0, 0.5, false, 0 );
      fadeKnob.SetKnobParams( 215, 145 );
      fadeKnob.DisplayValueInPercent( true );
      fadeKnob.SetKnobAdjustsRing( true );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "10ms" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 40, 331 );
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
      textLabel14.SetPosition( 102, 331 );
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

      rangeSwitch = new VoltageSwitch( "rangeSwitch", "Range", this, 0 );
      AddComponent( rangeSwitch );
      rangeSwitch.SetWantsMouseNotifications( false );
      rangeSwitch.SetPosition( 62, 331 );
      rangeSwitch.SetSize( 37, 15 );
      rangeSwitch.SetSkin( "5-State Slide Horizontal" );

      lengthCvIn = new VoltageAudioJack( "lengthCvIn", "Length CV In", this, JackType.JackType_AudioInput );
      AddComponent( lengthCvIn );
      lengthCvIn.SetWantsMouseNotifications( false );
      lengthCvIn.SetPosition( 11, 146 );
      lengthCvIn.SetSize( 25, 25 );
      lengthCvIn.SetSkin( "Mini Jack 25px" );

      lengthCvAmount = new VoltageKnob( "lengthCvAmount", "Length CV Amount", this, -1, 1.0, 0 );
      AddComponent( lengthCvAmount );
      lengthCvAmount.SetWantsMouseNotifications( false );
      lengthCvAmount.SetPosition( 45, 149 );
      lengthCvAmount.SetSize( 20, 20 );
      lengthCvAmount.SetSkin( "ARP2500 Sm Red" );
      lengthCvAmount.SetRange( -1, 1.0, 0, false, 0 );
      lengthCvAmount.SetKnobParams( 215, 145 );
      lengthCvAmount.DisplayValueInPercent( true );
      lengthCvAmount.SetKnobAdjustsRing( true );

      pitchCvIn = new VoltageAudioJack( "pitchCvIn", "Pitch CV In", this, JackType.JackType_AudioInput );
      AddComponent( pitchCvIn );
      pitchCvIn.SetWantsMouseNotifications( false );
      pitchCvIn.SetPosition( 11, 301 );
      pitchCvIn.SetSize( 25, 25 );
      pitchCvIn.SetSkin( "Mini Jack 25px" );

      pitchCvAmount = new VoltageKnob( "pitchCvAmount", "pitchCvAmount", this, -1, 1.0, 0 );
      AddComponent( pitchCvAmount );
      pitchCvAmount.SetWantsMouseNotifications( false );
      pitchCvAmount.SetPosition( 45, 304 );
      pitchCvAmount.SetSize( 20, 20 );
      pitchCvAmount.SetSkin( "ARP2500 Sm Blue" );
      pitchCvAmount.SetRange( -1, 1.0, 0, false, 0 );
      pitchCvAmount.SetKnobParams( 215, 145 );
      pitchCvAmount.DisplayValueInPercent( true );
      pitchCvAmount.SetKnobAdjustsRing( true );

      fadeCvIn = new VoltageAudioJack( "fadeCvIn", "Fade CV In", this, JackType.JackType_AudioInput );
      AddComponent( fadeCvIn );
      fadeCvIn.SetWantsMouseNotifications( false );
      fadeCvIn.SetPosition( 11, 198 );
      fadeCvIn.SetSize( 25, 25 );
      fadeCvIn.SetSkin( "Mini Jack 25px" );

      fadeCvAmount = new VoltageKnob( "fadeCvAmount", "fadeCvAmount", this, -1, 1.0, 0 );
      AddComponent( fadeCvAmount );
      fadeCvAmount.SetWantsMouseNotifications( false );
      fadeCvAmount.SetPosition( 45, 201 );
      fadeCvAmount.SetSize( 20, 20 );
      fadeCvAmount.SetSkin( "ARP2500 Sm Red" );
      fadeCvAmount.SetRange( -1, 1.0, 0, false, 0 );
      fadeCvAmount.SetKnobParams( 215, 145 );
      fadeCvAmount.DisplayValueInPercent( true );
      fadeCvAmount.SetKnobAdjustsRing( true );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "IN L" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 7, 18 );
      textLabel11.SetSize( 34, 18 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "<Sans-Serif>", 10, true, false );

      loopInR = new VoltageAudioJack( "loopInR", "Loop In R", this, JackType.JackType_AudioInput );
      AddComponent( loopInR );
      loopInR.SetWantsMouseNotifications( false );
      loopInR.SetPosition( 83, 41 );
      loopInR.SetSize( 25, 25 );
      loopInR.SetSkin( "Mini Jack 25px" );

      textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "OUT L" );
      AddComponent( textLabel16 );
      textLabel16.SetWantsMouseNotifications( false );
      textLabel16.SetPosition( 43, 18 );
      textLabel16.SetSize( 34, 18 );
      textLabel16.SetEditable( false, false );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel16.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel16.SetBorderSize( 1 );
      textLabel16.SetMultiLineEdit( false );
      textLabel16.SetIsNumberEditor( false );
      textLabel16.SetNumberEditorRange( 0, 100 );
      textLabel16.SetNumberEditorInterval( 1 );
      textLabel16.SetNumberEditorUsesMouseWheel( false );
      textLabel16.SetHasCustomTextHoverColor( false );
      textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "IN R" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 79, 18 );
      textLabel15.SetSize( 34, 18 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel15.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 1 );
      textLabel15.SetMultiLineEdit( false );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "OUT R" );
      AddComponent( textLabel17 );
      textLabel17.SetWantsMouseNotifications( false );
      textLabel17.SetPosition( 115, 18 );
      textLabel17.SetSize( 34, 18 );
      textLabel17.SetEditable( false, false );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel17.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel17.SetBorderSize( 1 );
      textLabel17.SetMultiLineEdit( false );
      textLabel17.SetIsNumberEditor( false );
      textLabel17.SetNumberEditorRange( 0, 100 );
      textLabel17.SetNumberEditorInterval( 1 );
      textLabel17.SetNumberEditorUsesMouseWheel( false );
      textLabel17.SetHasCustomTextHoverColor( false );
      textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetFont( "<Sans-Serif>", 10, true, false );

      textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "BALANCE" );
      AddComponent( textLabel18 );
      textLabel18.SetWantsMouseNotifications( false );
      textLabel18.SetPosition( 7, 229 );
      textLabel18.SetSize( 106, 15 );
      textLabel18.SetEditable( false, false );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel18.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel18.SetBorderSize( 1 );
      textLabel18.SetMultiLineEdit( false );
      textLabel18.SetIsNumberEditor( false );
      textLabel18.SetNumberEditorRange( 0, 100 );
      textLabel18.SetNumberEditorInterval( 1 );
      textLabel18.SetNumberEditorUsesMouseWheel( false );
      textLabel18.SetHasCustomTextHoverColor( false );
      textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetFont( "<Sans-Serif>", 10, true, false );

      balanceKnob = new VoltageKnob( "balanceKnob", "Balance Knob", this, 0, 1.0, 0.5 );
      AddComponent( balanceKnob );
      balanceKnob.SetWantsMouseNotifications( false );
      balanceKnob.SetPosition( 83, 249 );
      balanceKnob.SetSize( 27, 27 );
      balanceKnob.SetSkin( "Plastic Red" );
      balanceKnob.SetRange( 0, 1.0, 0.5, false, 0 );
      balanceKnob.SetKnobParams( 215, 145 );
      balanceKnob.DisplayValueInPercent( true );
      balanceKnob.SetKnobAdjustsRing( true );

      balanceCvIn = new VoltageAudioJack( "balanceCvIn", "Balance CV In", this, JackType.JackType_AudioInput );
      AddComponent( balanceCvIn );
      balanceCvIn.SetWantsMouseNotifications( false );
      balanceCvIn.SetPosition( 11, 249 );
      balanceCvIn.SetSize( 25, 25 );
      balanceCvIn.SetSkin( "Mini Jack 25px" );

      balanceCvAmount = new VoltageKnob( "balanceCvAmount", "Balance CV Amoujnt", this, -1, 1.0, 0 );
      AddComponent( balanceCvAmount );
      balanceCvAmount.SetWantsMouseNotifications( false );
      balanceCvAmount.SetPosition( 45, 252 );
      balanceCvAmount.SetSize( 20, 20 );
      balanceCvAmount.SetSkin( "ARP2500 Sm Red" );
      balanceCvAmount.SetRange( -1, 1.0, 0, false, 0 );
      balanceCvAmount.SetKnobParams( 215, 145 );
      balanceCvAmount.DisplayValueInPercent( true );
      balanceCvAmount.SetKnobAdjustsRing( true );

      textLabel19 = new VoltageLabel( "textLabel19", "textLabel19", this, "AUTO" );
      AddComponent( textLabel19 );
      textLabel19.SetWantsMouseNotifications( false );
      textLabel19.SetPosition( 115, 126 );
      textLabel19.SetSize( 34, 15 );
      textLabel19.SetEditable( false, false );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel19.SetColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetBkColor( new Color( 255, 65, 65, 255 ) );
      textLabel19.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel19.SetBorderSize( 1 );
      textLabel19.SetMultiLineEdit( false );
      textLabel19.SetIsNumberEditor( false );
      textLabel19.SetNumberEditorRange( 0, 100 );
      textLabel19.SetNumberEditorInterval( 1 );
      textLabel19.SetNumberEditorUsesMouseWheel( false );
      textLabel19.SetHasCustomTextHoverColor( false );
      textLabel19.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetFont( "<Sans-Serif>", 10, true, false );

      autoButton = new VoltageToggle( "autoButton", "Auto Trigger Button", this, false, 0 );
      AddComponent( autoButton );
      autoButton.SetWantsMouseNotifications( false );
      autoButton.SetPosition( 121, 149 );
      autoButton.SetSize( 21, 21 );
      autoButton.SetSkin( "Mini Amber" );
      autoButton.ShowOverlay( false );
      autoButton.SetOverlayText( "" );
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
      controller = connector.connect(
            triggerIn,
            triggerButton,
            lengthCvIn,
            lengthCvAmount,
            lengthKnob,
            autoButton,
            octaveUpButton,
            reverseButton,
            pitchCvIn,
            pitchCvAmount,
            pitchKnob,
            fadeCvIn,
            fadeCvAmount,
            fadeKnob,
            balanceCvIn,
            balanceCvAmount,
            balanceKnob,
            modOut,
            loopInL,
            loopInR,
            loopOutL,
            loopOutR,
            fadeOutTrigger,
            rangeSwitch);

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
      
         case Button_Changed: return eventHandler.onButtonChanged(component, doubleValue);
      
         case Switch_Changed: return eventHandler.onSwitchChanged(component, doubleValue);
      
         case Jack_Connected: return eventHandler.onJackConnected(component);
      
         case Jack_Disconnected: return eventHandler.onJackDisconnected(component);
         
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
            activeIndicator.SetValue(controller.isPlaying() ? 1.0 : 0.0);
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
      if (component == lengthKnob) {
         return controller.getEffectiveLengthDescription();
      }
      
      if (component == rangeSwitch) {
         return controller.getRangeDescription(rangeSwitch.GetValue());
      }
      
      if (component == balanceKnob) {
         var pcRight = (int) (balanceKnob.GetValue() * 100);
         var pcLeft = 100 - pcRight;
         if (pcLeft == 100) { return "Hard Left"; }
         if (pcRight == 100) { return "Hard Right"; }
         return pcLeft + "% left, " + pcRight + "% right";
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
   private VoltageToggle autoButton;
   private VoltageLabel textLabel19;
   private VoltageKnob balanceCvAmount;
   private VoltageAudioJack balanceCvIn;
   private VoltageKnob balanceKnob;
   private VoltageLabel textLabel18;
   private VoltageLabel textLabel17;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel16;
   private VoltageAudioJack loopInR;
   private VoltageLabel textLabel11;
   private VoltageKnob fadeCvAmount;
   private VoltageAudioJack fadeCvIn;
   private VoltageKnob pitchCvAmount;
   private VoltageAudioJack pitchCvIn;
   private VoltageKnob lengthCvAmount;
   private VoltageAudioJack lengthCvIn;
   private VoltageSwitch rangeSwitch;
   private VoltageLabel textLabel14;
   private VoltageLabel textLabel13;
   private VoltageKnob fadeKnob;
   private VoltageLabel textLabel9;
   private VoltageLED activeIndicator;
   private VoltageAudioJack modOut;
   private VoltageLabel textLabel7;
   private VoltageAudioJack loopOutR;
   private VoltageAudioJack fadeOutTrigger;
   private VoltageAudioJack loopOutL;
   private VoltageKnob pitchKnob;
   private VoltageLabel textLabel6;
   private VoltageToggle reverseButton;
   private VoltageKnob lengthKnob;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel10;
   private VoltageAudioJack loopInL;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel5;
   private VoltageToggle octaveUpButton;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageButton triggerButton;
   private VoltageAudioJack triggerIn;
   private VoltageLabel textLabel1;


   //[user-code-and-variables]    Add your own variables and functions here
private Controller controller;
private final EventBus eventBus = new EventBus();
private final UIEventHandler eventHandler = new UIEventHandler(eventBus);
private final UIEventConnector eventConnector = new UIEventConnector(eventBus);
private final Connector connector = new Connector(eventConnector);




   //[/user-code-and-variables]
}

 
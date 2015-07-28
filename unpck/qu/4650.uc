class 4650 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.sp_dryad_root_ta'
		bOnMultiTarget=True
	End Object
	Desc="NPC AE - Dispel Hold" //NPC AE - Dispel Hold
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
}
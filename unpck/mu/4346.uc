class 4346 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect14
		AttachOn=AM_LA
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_mental_shield_ta'
		bOnMultiTarget=True
	End Object
	Desc="아지트 맨탈 실드" //Maental hideout Shield
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect14',SpecificStage=0)
}
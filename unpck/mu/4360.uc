class 4360 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect9
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_death_whisper_ta'
		bOnMultiTarget=True
	End Object
	Desc="아지트 데스 위스퍼" //Deathwhisper hideout
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect9',SpecificStage=0)
}